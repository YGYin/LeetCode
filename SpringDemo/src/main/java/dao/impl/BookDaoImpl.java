package dao.impl;

import dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("Book Dao Save...");
    }
}
