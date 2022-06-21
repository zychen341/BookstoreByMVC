package com.zychen.controller;

import com.zychen.pojo.Account;
import com.zychen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    @Qualifier("AccountServiceImpl")
    private AccountService accountService;

    public static String onlyAccount;

    //登录
    @RequestMapping("/loading")
    public String loading(Account account, Model model){
        List<Account> accounts = accountService.queryAllAccount();
        onlyAccount = account.getAccount();
        for (Account account1 : accounts) {
            if (account1.getAccount().equals(account.getAccount())){
                if (account1.getPassword().equals(account.getPassword())) {
                    return "redirect:/book/allbook";
                }
            }
        }
        return "login_error";
    }

    //注册
    @RequestMapping("/regist")
    public String registAccount(Account account,String repwd){
        System.out.println(repwd);
        System.out.println(account);
        List<Account> accounts = accountService.queryAllAccount();
        for (Account account1 : accounts) {
            if (account1.getAccount().equals(account.getAccount())){
                return "regist_error";
            }
        }
        if (account.getPassword().equals(repwd)){
            accountService.addAccount(account);
            return "regist_success";
        }
        return "regist_error_pass";
    }

    //查看个人信息
    @RequestMapping("/showInformation")
    public String showInformation(Model model){
        List<Account> accounts = accountService.queryAllAccount();
        for (Account account : accounts) {
            if (account.getAccount().equals(AccountController.onlyAccount)){
                model.addAttribute("account",account);
                return "personal";
            }
        }
        return "personal";
    }

    //充值
    @RequestMapping("/recharge")
    public String recharge(double addMoney,Model model){
        accountService.updateMoney(AccountController.onlyAccount,addMoney);
        return "recharge_success";
    }

    //修改密码
    @RequestMapping("/updatePassword")
    public String updatePassword(String newpwd,String renewpwd,Model model){
        if (!newpwd.equals(renewpwd)){
            return "updatePWD_error";
        }
        accountService.updatePassword(AccountController.onlyAccount,newpwd);
        return "updatePWD_success";
    }
}
