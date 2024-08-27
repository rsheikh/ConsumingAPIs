package org.northcoders.model;

import java.util.Date;

public record Book(Integer id, String title, String author, String isbn, Date published) {
}
