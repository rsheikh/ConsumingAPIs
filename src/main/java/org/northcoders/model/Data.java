package org.northcoders.model;

import java.util.ArrayList;

public record Data(String status, Integer code, Integer total, ArrayList<Book> data) {
}
