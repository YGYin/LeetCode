package javase.jdbc;

public class MysqlJdbcImpl implements JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("Get MySQL connection");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("MySQL CRUD finished.");
    }

    @Override
    public void close() {
        System.out.println("MySQL closed");
    }
}
