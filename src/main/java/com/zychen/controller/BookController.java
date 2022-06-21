package com.zychen.controller;

import com.zychen.pojo.Book;
import com.zychen.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //展示所有书籍
    @RequestMapping("/allbook")
    public String list(Model model){
        List<Book> books = bookService.queryAllBook();
        model.addAttribute("books",books);
        return "allbook";
    }

    //搜索书籍
    @RequestMapping("/querybook")
    public String queryBook(String bookName,Model model){
        List<Book> books = bookService.queryBook(bookName);
        model.addAttribute("books",books);
        return "allbook";
    }
}
