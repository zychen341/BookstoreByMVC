package com.zychen.service;

import com.zychen.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> queryAccount(String account,String password);

    List<Account> queryAllAccount();

    int addAccount(Account account);

    int updateMoney(String account,double addMoney);

    int updatePassword(String account,String password);
}
