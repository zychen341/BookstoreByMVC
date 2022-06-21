package com.zychen.service;

import com.zychen.dao.AccountMapper;
import com.zychen.pojo.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService{
    private AccountMapper accountMapper;

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public List<Account> queryAccount(String account, String password) {
        return accountMapper.queryAccount(account,password);
    }

    public List<Account> queryAllAccount() {
        return accountMapper.queryAllAccount();
    }

    public int addAccount(Account account) {
        return accountMapper.addAccount(account);
    }

    public int updateMoney(String account, double addMoney) {
        return accountMapper.updateMoney(account,addMoney);
    }

    public int updatePassword(String account, String password) {
        return accountMapper.updatePassword(account,password);
    }
}
