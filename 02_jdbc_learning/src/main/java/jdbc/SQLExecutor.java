package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

/**
 * class SQLExecutor
 *
 * @Description //执行SQL脚本文件
 * @Author wangyu
 * @Date 2021/8/27 15:57
 **/
public class SQLExecutor {
    public static void main(String[] args) throws Exception{
        if (args.length == 0) {
            System.out.println("请提供SQL脚本文件名");
        }
        String sqlFile = args[0];

        ConnectionProvider provider = new ConnectionProvider();
        Connection connection = provider.getConnection();
        Statement statement = connection.createStatement();
        BufferedReader reader = new BufferedReader(new FileReader(new File(sqlFile)));
        try {
            String data;
            String sql = "";
            while ((data = reader.readLine()) != null) {
                data = data.trim();
                if (data.length() == 0 ) {
                    continue;
                }
                sql = sql + data;
                if (sql.endsWith(";")) {
                    System.out.println(sql);
                    boolean hasResult = statement.execute(sql);
                    if (hasResult) {
                        showResultSet(statement.getResultSet());
                    }
                    sql = "";
                }
            }
        } finally {
            connection.close();
        }
    }

    public static void showResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 0; i <= columnCount; i++) {
            if (i > 1) {
                System.out.print(",");
            }
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();
        while (resultSet.next()) {
            for (int i = 0; i < columnCount; i++) {
                if (i > 1) {
                    System.out.print(",");
                }
                System.out.print(resultSet.getString(i));
            }
            System.out.println();
        }
        resultSet.close();
    }
}
