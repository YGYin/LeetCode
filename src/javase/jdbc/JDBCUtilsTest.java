package javase.jdbc;

import java.sql.*;

public class JDBCUtilsTest {

    // dml
    public void testDML() {
        Connection connection = null;
        String sql = "update actor set name = ? where id = ?";
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Alex");
            preparedStatement.setInt(2, 3);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }

    }

    // select
    public void testSelect() {
        Connection connection = null;
        String sql = "select * from actor";
        PreparedStatement preparedStatement = null;
        ResultSet set = null;

        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            set = preparedStatement.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String gender = set.getString("gender");
                Date birth = set.getDate("birth");
                //...
                System.out.println(id + "\t" + name + "\t" + gender + "\t" + birth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(set, preparedStatement, connection);
        }
    }
}
