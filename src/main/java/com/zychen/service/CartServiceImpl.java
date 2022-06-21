package com.zychen.service;

import com.zychen.dao.CartMapper;
import com.zychen.pojo.Cart;

import java.util.List;

public class CartServiceImpl implements CartService{
    private CartMapper cartMapper;

    public void setCartMapper(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<Cart> queryAllCart() {
        return cartMapper.queryAllCart();
    }

    public int addCart(Cart cart) {
        return cartMapper.addCart(cart);
    }

    public int deleteCartById(int id) {
        return cartMapper.deleteCartById(id);
    }

    public int updateCartById(int id) {
        return cartMapper.updateCartById(id);
    }

    public int clearCartByAccount(String account) {
        return cartMapper.clearCartByAccount(account);
    }

    public int updateCartByBookName(String bookName, double price, String account) {
        return cartMapper.updateCartByBookName(bookName,price,account);
    }

    public int deleteCartById2(int id) {
        return cartMapper.deleteCartById2(id);
    }


}
