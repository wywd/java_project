package jdbc;

import java.io.UnsupportedEncodingException;
import java.sql.*;

/**
 * class DBTester
 *
 * @Description //数据库的连接，以及简单应用的例子
 * @Author wangyu
 * @Date 2021/8/25 22:37
 **/
public class DBTester {
    public static void main(String[] args) throws UnsupportedEncodingException, SQLException, ClassNotFoundException {
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        //加载驱动器，下面的代码加载MySQL驱动器
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库的URL，serverTimeZone表示时区
        String dbUrl = "jdbc:mysql://localhost:3306/storedb?user=dbuser&password=1234&useUnicode=true&characterEncoding=UTF8&useSSL=false";
//        String dbUser = "dbuser";
//        String dbpwd = "1234";
//        connection = DriverManager.getConnection(dbUrl, dbUser, dbpwd);
        connection = DriverManager.getConnection(dbUrl);
        statement = connection.createStatement();
        System.out.println("数据库连接成功");
        //字符编码转换
        statement.executeUpdate("insert into customers (name, age, address) values('小王', 20, '上海')");
        resultSet = statement.executeQuery("select id, name, age, address from customers");
        while (resultSet.next()) {
            long id = resultSet.getLong(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String address = resultSet.getString(4);

            System.out.println("id=" + id + ",name=" + name + ",age=" + age + ",address=" + address);
        }
        statement.executeUpdate("delete from customers where name='小王'");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
