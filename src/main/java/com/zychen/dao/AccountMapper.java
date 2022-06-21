package com.zychen.dao;

import com.zychen.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {
    //查询
    List<Account> queryAccount(@Param("account")String account,@Param("password")String password);
    //查询
    List<Account> queryAllAccount();
    //注册、添加用户
    int addAccount(Account account);
    //根据account修改money
    int updateMoney(@Param("account")String account,@Param("addMoney")double addMoney);
    //修改密码根据account
    int updatePassword(@Param("account")String account,@Param("password")String password);
}
