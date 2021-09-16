package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class GetKey
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 16:58
 **/
public class GetKey {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionProvider().getConnection();
        Statement statement = connection.createStatement();
        //增加记录
        statement.executeUpdate("insert into customers (name, age, address) values ('小王', 20, '上海')",
                Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys(); // 获得包含主键的ResultSet对象
        if (resultSet.next()) {
            System.out.println("id= " + resultSet.getInt(1)); // 获取主键
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
