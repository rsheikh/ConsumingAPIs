package org.schipol;

import org.schipol.dao.SchipolDAO;
import org.schipol.model.Flights;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Schipol!");

        SchipolDAO schipolDAO = new SchipolDAO();

        String uri = "https://api.schiphol.nl/public-flights/flights";
        ResponseEntity<Flights> flights = schipolDAO.getResponseBody(uri);

        System.out.println("Flights : " + flights);
    }
}
