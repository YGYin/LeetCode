package javase.jdbc;

public class JdbcTest {
    public static void main(String[] args) {
        JdbcInterface jdbcMysql = new MysqlJdbcImpl();
        jdbcMysql.getConnection(); // 通过接口来调用实现类，动态绑定
        jdbcMysql.crud();
        jdbcMysql.close();

        JdbcInterface jdbcOracle = new OracleJdbcImpl();
        jdbcOracle.getConnection();
        jdbcOracle.crud();
        jdbcOracle.close();
    }
}
