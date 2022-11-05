package javase.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbc_1 {
    public static void main(String[] args) throws Exception {
        // 1. Driver
        // Method 1
        // new com.mysql.cj.jdbc.Driver
        // Driver driver = new Driver();
        // Method 2
        // 反射加载 Driver 类
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        // 2. Connection, socket connection
        String url = "jdbc:mysql://localhost:3306/db01";
        // Put your user and pwd into a Properties object
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "YGYin0307");

        // Get the connection
        Connection connect = driver.connect(url, properties);

        // 3. CRUD
        String sql = "insert into actor values(null, 'Jay', 'male', '2000-12-12','234')";
        // statement 用于执行静态 sql 语句并返回其生成的结果的对象
        Statement statement = connect.createStatement();
        // 如果为 dml 语句，返回的为受影响的行数
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "Success" : "Fail");

        // Close
        statement.close();
        connect.close();
    }
}
