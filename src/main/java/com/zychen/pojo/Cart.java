package com.zychen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String bookName;
    private double price;
    private int bookQuanities;
    private String account;
    private int id;
    private double allPrice;

    public double getAllPrice() {
        return price * bookQuanities;
    }

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

    public Cart(String bookName, double price, String account,int bookQuanities) {
        this.bookName = bookName;
        this.price = price;
        this.account = account;
        this.bookQuanities = bookQuanities;
    }

    public int getId() {
        return id;
    }
}
