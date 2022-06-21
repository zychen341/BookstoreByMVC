package com.zychen.pojo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String account;
    private String pwd;
    private double money;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return pwd;
    }

    public double getMoney() {
        return money;
    }
}
