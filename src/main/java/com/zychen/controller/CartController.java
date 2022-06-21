package com.zychen.controller;

import com.zychen.pojo.Account;
import com.zychen.pojo.Book;
import com.zychen.pojo.Cart;
import com.zychen.pojo.Package;
import com.zychen.service.AccountServiceImpl;
import com.zychen.service.BookServiceImpl;
import com.zychen.service.CartService;
import com.zychen.service.PackageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    @Qualifier("CartServiceImpl")
    private CartService cartService;

    @RequestMapping("/showCart")
    public String queryCart(Model model){
        double allprice = 0.0;
        List<Cart> carts = cartService.queryAllCart();
        List<Cart> onlyAccountCart = new ArrayList<Cart>();
        for (Cart cart : carts) {
            if (cart.getAccount().equals(AccountController.onlyAccount)){
                allprice = allprice + cart.getAllPrice();
                onlyAccountCart.add(cart);
            }

        }
        model.addAttribute("carts",onlyAccountCart);
        model.addAttribute("allprice",allprice);
        return "cart";
    }

    //添加购物车
    @RequestMapping("/addToCart")
    public String addToCart(int id){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServiceImpl bookServiceImpl = context.getBean("BookServiceImpl", BookServiceImpl.class);
        Book book = bookServiceImpl.queryBookById(id);
        List<Cart> carts = cartService.queryAllCart();
        for (Cart cart : carts) {
            if (cart.getBookName().equals(book.getBookName()) && cart.getPrice() == book.getPrice() && cart.getAccount().equals(AccountController.onlyAccount)){
                cartService.updateCartByBookName(book.getBookName(),book.getPrice(),AccountController.onlyAccount);
                return "redirect:/book/allbook";
            }
        }
        Cart cart = new Cart(book.getBookName(),book.getPrice(),AccountController.onlyAccount,1);
        cartService.addCart(cart);
        return "redirect:/book/allbook";
    }

    //清空购物车
    @RequestMapping("/clearCart")
    public String clearCart(){
        cartService.clearCartByAccount(AccountController.onlyAccount);
        return "redirect:/cart/showCart";
    }

    //删除购物车byid
    @RequestMapping("/deleteCartById")
    public String deleteCartById(int id,int bookQuanities){
        if (bookQuanities>=2){
            cartService.deleteCartById2(id);
            return "redirect:/cart/showCart";
        }
        cartService.deleteCartById(id);
        return "redirect:/cart/showCart";
    }

    //增加购物车byid
    @RequestMapping("/updateCartById")
    public String updateCartById(int id){
        cartService.updateCartById(id);
        return "redirect:/cart/showCart";
    }

    //买单
    @RequestMapping("/pay")
    public String pay(){
        double total = 0.0;
        double allMoney = 0.0;
        List<Cart> carts = cartService.queryAllCart();
        List<Cart> cartList = new ArrayList<Cart>();
        Package pack;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl accountServiceImpl = context.getBean("AccountServiceImpl", AccountServiceImpl.class);
        PackageServiceImpl packageService = context.getBean("PackageServiceImpl", PackageServiceImpl.class);
        List<Account> accounts = accountServiceImpl.queryAllAccount();
        for (Account account : accounts) {
            if (account.getAccount().equals(AccountController.onlyAccount)){
                allMoney = account.getMoney();
            }
        }
        for (Cart cart : carts) {
            if (cart.getAccount().equals(AccountController.onlyAccount)){
                total = total + cart.getAllPrice();
                cartList.add(cart);
            }
        }
        if(allMoney<total){
            return "pay_error";
        }
        cartService.clearCartByAccount(AccountController.onlyAccount);
        for (Cart cart : cartList) {
            pack = new Package(cart.getBookName(),cart.getPrice(),cart.getBookQuanities(),cart.getAccount());
            packageService.addPackage(pack);
        }
        return "redirect:/cart/showCart";
    }
}
