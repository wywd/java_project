package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class ExceptionTester
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 16:37
 **/
public class ExceptionTester {
    public static void main(String[] args) {
        try {
//            DriverManager.setLogWriter(new PrintWriter(System.out, true));
            Connection connection = new ConnectionProvider().getConnection();
            Statement statement = connection.createStatement();
            // 抛出SQLException
            ResultSet resultSet = statement.executeQuery("select firstname from customers");
        } catch (SQLException e) {
            System.out.println("ErrorCode:" + e.getErrorCode());
            System.out.println("SQLState:" + e.getSQLState());
            System.out.println("REason:" + e.getMessage());
        }
    }
}
