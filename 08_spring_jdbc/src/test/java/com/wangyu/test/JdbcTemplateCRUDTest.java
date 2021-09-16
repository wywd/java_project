package com.wangyu.test;

import com.wangyu.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * class JdbcTemplateCRUDTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/12 23:40
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test //测试查询单个简单数据操作(聚合查询)
    public void testQueryCount() {
        Long aLong= jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }

    @Test
    public void testQueryOne() {
        Account account = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<>(Account.class), "姜紫婷");
        System.out.println(account);
    }

    @Test
    public void testQueryAll() {
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testUpdate() {
        jdbcTemplate.update("update account set money=? where name=?", 9999, "姜紫婷");
    }

    @Test
    public void testDelete() {
        jdbcTemplate.update("delete from account where name=?", "tom");
    }


}
