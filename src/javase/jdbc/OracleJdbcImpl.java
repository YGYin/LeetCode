package javase.jdbc;

public class OracleJdbcImpl implements JdbcInterface {
    @Override
    public Object getConnection() {
        System.out.println("Get ORACLE connection");
        return null;
    }

    @Override
    public void crud() {
        System.out.println("ORACLE CRUD finished");
    }

    @Override
    public void close() {
        System.out.println("ORACLE closed");
    }
}
