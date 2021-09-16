package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * class ConnectionProvider
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 11:53
 **/
public class ConnectionProvider {
    private String jdbc_driver;
    private String db_url;
    private String db_user;
    private String db_password;

    public ConnectionProvider() {
        jdbc_driver = jdbc.PropertyReader.get("jdbc_driver");
        db_url = jdbc.PropertyReader.get("db_url");
        db_user = jdbc.PropertyReader.get("db_user");
        db_password = jdbc.PropertyReader.get("db_password");
        try {
            Class.forName(jdbc_driver);
            System.out.println("数据驱动加载成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(db_url, db_user, db_password);
    }
}
