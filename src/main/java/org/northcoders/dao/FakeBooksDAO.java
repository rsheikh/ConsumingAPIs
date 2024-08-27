package org.northcoders.dao;

import org.northcoders.model.Book;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class FakeBooksDAO {

    public void getResponseBody() {
        WebClient webClient = WebClient.create();

        Mono<Book> bookMono = webClient.get()
                .uri("https://fakerapi.it/api/v1/books")
                .retrieve()
                .bodyToMono(Book.class);

        System.out.println(bookMono.blockOptional());
    }



}
