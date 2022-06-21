package com.zychen.service;

import com.zychen.pojo.Cart;

import java.util.List;

public interface CartService {
    //展示购物车
    List<Cart> queryAllCart();
    //添加购物车
    int addCart(Cart cart);

    //删除
    int deleteCartById(int id);

    //修改
    int updateCartById(int id);

    //清空
    int clearCartByAccount(String account);

    //修改
    int updateCartByBookName(String bookName,double price,String account);

    //删除
    int deleteCartById2(int id);
}
