package service.impl;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import service.BookService;


public class BookServiceImpl implements BookService {
    // DI: 1. 删除业务层中使用 new 方式创建的 dao 对象
    // private BookDao bookDao = new BookDaoImpl();
    private BookDao bookDao;

    @Override
    public void save() {
        System.out.println("Book Service Save...");
        bookDao.save();
    }

    // DI: 2. 提供依赖对象对应的 set 方法，供容器传递对象
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
