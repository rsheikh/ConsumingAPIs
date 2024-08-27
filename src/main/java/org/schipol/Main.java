package org.schipol;

import org.schipol.dao.SchipolDAO;
import org.schipol.model.Data;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Schipol!");

        SchipolDAO schipolDAO = new SchipolDAO();

        String uri = "https://api.schiphol.nl/public-flights/flights";
        ResponseEntity<Data> flights = schipolDAO.getResponseBody(uri);

        if(flights != null) {
            System.out.println("Flights : " + flights.getBody().flights());
        } else {
            System.out.println("There aren't any flights which isn't right");
        }
    }
}
