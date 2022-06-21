package com.zychen.service;

import com.zychen.dao.BookMapper;
import com.zychen.pojo.Book;

import java.util.List;

public class BookServiceImpl implements BookService{

//    service 调 dao : 组合dao
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    public Book queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    public List<Book> queryBook(String bookName) {
        return bookMapper.queryBook(bookName);
    }
}
