package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * class ShowDB
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/8/27 17:21
 **/
public class ShowDB {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionProvider().getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("允许的最大连接数为：" + metaData.getMaxConnections());
        System.out.println("一个连接允许同时打开的Statement对象的数目为：" + metaData.getMaxStatements());
        System.out.println("JDBC版本：" + metaData.getJDBCMajorVersion());
        //返回数据库中的所有表
        ResultSet tables = metaData.getTables(null, null, null, new String[]{"table"});
        SQLExecutor.showResultSet(tables);
        connection.close();
    }
}
