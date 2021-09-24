package com.wangyu;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wangyu.domain.User;
import com.wangyu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * class MyBatisTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 20:27
 **/

public class MyBatisTest {
    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 创造一个User对象
        User user = new User();
        user.setUsername("测试人员");
        user.setPassword("abc");
        user.setBirthday(new Date());
        // 执行保存操作
        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findById(8);
        System.out.println("用户的生日：" + user.getBirthday());
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 设置分页的相关参数，当前页+每页显示的条数
        PageHelper.startPage(2, 2);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        // 获得与分页相关的参数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("当前页:" + pageInfo.getPageNum());
        System.out.println("每页显示条数:" + pageInfo.getPageSize());
        System.out.println("总条数:" + pageInfo.getTotal());
        System.out.println("总页数:" + pageInfo.getPages());
        System.out.println("上一页:" + pageInfo.getPrePage());
        System.out.println("下一页:" + pageInfo.getNextPage());
        System.out.println("是否是第一页:" + pageInfo.isIsFirstPage());
        System.out.println("是否是第最后页:" + pageInfo.isIsLastPage());

        sqlSession.close();
    }
}
