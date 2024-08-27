package org.northcoders;

import org.northcoders.dao.FakeBooksDAO;
import org.northcoders.model.Book;
import org.northcoders.model.Data;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FakeBooksDAO fbdao = new FakeBooksDAO();
        ArrayList<String> params = new ArrayList<>();
        params.add("_quantity=5");
        params.add("_locale=fr_FR");

        String uriWithParams = fbdao.getQueryWithParameters(params);
        ResponseEntity<Data> data = fbdao.getResponseBody(uriWithParams);

        ArrayList<Book> books = fbdao.getListOfBooks(data);
        System.out.println("Books" + books);
    }
}