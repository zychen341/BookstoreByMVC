package com.zychen.dao;

import com.zychen.pojo.Book;
import com.zychen.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {

    //展示购物车
    List<Cart> queryAllCart();
    //添加购物车
    int addCart(Cart cart);

    //删除
    int deleteCartById(@Param("id") int id);

    //修改
    int updateCartById(@Param("id") int id);

    //清空
    int clearCartByAccount(String account);

    //修改
    int updateCartByBookName(@Param("bookName") String bookName,@Param("price") double price ,@Param("account") String account);

    //删除
    int deleteCartById2(@Param("id") int id);

}
