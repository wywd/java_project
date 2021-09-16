package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * class DBTester2
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 12:15
 **/
public class DBTester2 {

    private ConnectionProvider provider;

    public DBTester2 (ConnectionProvider provider) {
        this.provider = provider;
    }

    public void addCustomer(String name, int age, String address) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        try {
            con = provider.getConnection();
            stmt = con.createStatement();
            String sql = "insert into customers(name, age, address) values('" + name + "'," + age + ",'" + address + "')";
            stmt.execute(sql);
        } finally {
            closeStatement(stmt);
            closeConnection(con);
        }
    }

    public void deleteCustomer(String name) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        try {
            con = provider.getConnection();
            stmt = con.createStatement();
            String sql = "delete from customers where name = '" + name + "'";
            stmt.execute(sql);
        } finally {
            closeConnection(con);
            closeStatement(stmt);
        }
    }

    public void printAllCustomers() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = provider.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, name, age, address from customers");
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String address = rs.getString(4);
                System.out.println("id=" + id + ",name=" + name + ",age=" + age + ",address=" + address);
            }
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(con);
        }
    }


    private void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException{
        DBTester2 tester = new DBTester2(new ConnectionProvider());
        tester.addCustomer("小王", 20, "上海");
        tester.printAllCustomers();
        tester.deleteCustomer("小王");
    }
}
