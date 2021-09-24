package com.wangyu.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * class DateTypeHandler
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/23 19:15
 **/
public class DateTypeHandler extends BaseTypeHandler<Date> {
    @Override  // 负责将Java类型转换成数据库需要的类型
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long time = parameter.getTime();
        ps.setLong(i, time);
    }

    @Override  // 负责将数据库中的类型转换成Java类型-1
    // String参数:要转换的字段名字
    // ResultSet 查询出的结果集
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    @Override  // 负责将数据库中的类型转换成Java类型-2
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    @Override  // 负责将数据库中的类型转换成Java类型-3
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}

