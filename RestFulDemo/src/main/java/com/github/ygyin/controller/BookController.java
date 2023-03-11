package com.github.ygyin.controller;


import com.github.ygyin.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println(book);
        return "{module : book save success}";
    }

    @GetMapping
    public List<Book> getAll() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setType("CS");
        book1.setName("Spring Restful");
        book1.setDesc("111");
        bookList.add(book1);

        Book book2 = new Book();
        book1.setType("News");
        book1.setName("News Desc");
        book1.setDesc("222");
        bookList.add(book2);

        return bookList;
    }
}
