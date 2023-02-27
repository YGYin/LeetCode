package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;

import java.awt.print.Book;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void save() {
        System.out.println("Book Service Save...");
        bookDao.save();
    }
}
