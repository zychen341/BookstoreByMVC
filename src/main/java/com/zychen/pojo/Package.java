package com.zychen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Package {
    private String bookName;
    private double price;
    private int bookQuanities;
    private String account;
    private int id;

    public String getBookName() {
        return bookName;
    }

    public double getPrice() {
        return price;
    }

    public int getBookQuanities() {
        return bookQuanities;
    }

    public String getAccount() {
        return account;
    }

    public Package(String bookName, double price, int bookQuanities, String account) {
        this.bookName = bookName;
        this.price = price;
        this.bookQuanities = bookQuanities;
        this.account = account;
    }

    public int getId() {
        return id;
    }
}
