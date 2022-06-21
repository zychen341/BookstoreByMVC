package com.zychen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String bookName;
    private String author;
    private Double price;
    private int id;

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
