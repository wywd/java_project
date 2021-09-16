package com.wangyu.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

/**
 * class JdbcTempleTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/12 22:25
 **/
public class JdbcTempleTest {

    @Test
    // 测试Spring产生JdbcTemplate对象
    public void test2() throws PropertyVetoException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        // 执行操作
        int row = jdbcTemplate.update("insert into account values (?,?)", "姜紫婷", 5000);
        System.out.println(row);
    }

    @Test
    // 测试JdbcTemplate开发步骤
    public void test1() throws PropertyVetoException {
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("wyroot");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 设置数据源对象，知道数据库在哪儿
        jdbcTemplate.setDataSource(dataSource);
        // 执行操作
        int row = jdbcTemplate.update("insert into account values (?,?)", "tom", 5000);
        System.out.println(row);
    }
}
