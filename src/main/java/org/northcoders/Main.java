package org.northcoders;

import org.northcoders.dao.FakeBooksDAO;
import org.northcoders.model.Book;
import org.northcoders.model.Data;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FakeBooksDAO fbdao = new FakeBooksDAO();

        ResponseEntity<Data>  data = fbdao.getResponseBody();

        ArrayList<Book> books = fbdao.getListOfBooks(data);
        System.out.println("Books" + books);
    }
}