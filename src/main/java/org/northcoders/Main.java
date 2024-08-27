package org.northcoders;

import org.northcoders.dao.FakeBooksDAO;

public class Main {
    public static void main(String[] args) {
        FakeBooksDAO fbdao = new FakeBooksDAO();
        fbdao.getResponseBody();
    }
}