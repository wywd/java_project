package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class DBTester3
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 14:38
 **/
public class DBTester3 {
    private ConnectionProvider provider;
    private Connection connection;
    private PreparedStatement addStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement findStatement;

    public DBTester3(ConnectionProvider provider) throws SQLException {
        this.provider = provider;
        this.connection = provider.getConnection();
    }

    public void addCustomer(String name, int age, String address) throws SQLException{
        String sql = "insert into customers(name, age, address) values(?, ?, ?)";
        if (addStatement == null) {
            addStatement = connection.prepareStatement(sql);
        }
        addStatement.setString(1, name);
        addStatement.setInt(2, age);
        addStatement.setString(3, address);
        addStatement.execute();
    }

    public void deleteCustomer(String name) throws SQLException {
        String sql = "delete from customers where name = ?";
        if (deleteStatement == null) {
            deleteStatement = connection.prepareStatement(sql);
        }
        deleteStatement.setString(1, name);
        deleteStatement.execute();
    }

    private void findCustomer(String name, int age) throws SQLException {
        String sql = "select id, name, age, address from customers where name=? and age=?";
        if (findStatement == null) {
            findStatement = connection.prepareStatement(sql);
        }
        findStatement.setString(1, name);
        findStatement.setInt(2, age);
        ResultSet rs = findStatement.executeQuery();
        try {
            while (rs.next()) {
                long id = rs.getLong(1);
                String address = rs.getString(4);
                System.out.println("id=" + id + ",name=" + name + ",age=" + age + ",address=" + address);
            }
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DBTester3 tester = new DBTester3(new ConnectionProvider());
        tester.addCustomer("小王", 20, "上海");
        tester.addCustomer("小玲", 30, "上海");
        tester.findCustomer("小王", 20);
        tester.findCustomer("小玲", 30);
        tester.deleteCustomer("小王");
        tester.deleteCustomer("小玲");
    }
}
