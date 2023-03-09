package dao.impl;

import dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println(System.currentTimeMillis());
        System.out.println("Book dao save...");
    }

    @Override
    public void update() {
        System.out.println("Book dao update...");
    }
}
