package org.northcoders.dao;

import org.northcoders.model.Book;
import org.northcoders.model.Data;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

public class FakeBooksDAO {
    WebClient webClient;

    public ResponseEntity<Data> getResponseBody(String uri) {
        webClient = WebClient.create();

        ResponseEntity<Data> bookMono = webClient.get()
                .uri(uri).accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(Data.class)
                .block();

        return bookMono;
    }


    public ArrayList<Book> getListOfBooks(ResponseEntity<Data> response) {

        if(response != null) {
            return response.getBody().data();
        } else {
            throw new RuntimeException("No data found!");
        }
    }

    public String getQueryWithParameters(ArrayList<String> queryParams) {
        String uri = "https://fakerapi.it/api/v1/books/";
        if (!queryParams.isEmpty()) {
            for (int i = 0; i < queryParams.size(); i++) {
                if (i == 0) {
                    uri += "?" + queryParams.get(0);
                } else {
                    uri += "&" + queryParams.get(i);
                }
            }
        }
        return uri;
    }

    // https://fakeapi.it/api/v1/books/

}
