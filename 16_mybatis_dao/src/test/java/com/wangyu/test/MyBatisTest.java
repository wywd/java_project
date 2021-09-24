package com.wangyu.test;

import com.wangyu.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * class MyBatisTest
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 14:42
 **/
public class MyBatisTest {
    @Test  // 查询操作
    public void test1() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得sesison回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作;参数:namespace + id
        List<Object> userList = sqlSession.selectList("userMapper.findAll");
        // 打印数据
        System.out.println(userList);
        // 释放资源
        sqlSession.close();
    }

    @Test  // 插入操作
    public void test2() throws IOException {
        // 模拟User对象
        User user = new User();
        user.setUsername("王瑜");
        user.setPassword("wy123456");
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得sesison回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作;参数:namespace + id
        sqlSession.insert("userMapper.save", user);
        // myBatis执行更新操作,需要提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test  // 更新操作
    public void test3() throws IOException {
        // 模拟User对象
        User user = new User();
        user.setId(5);
        user.setUsername("姜紫婷");
        user.setPassword("jzt123456");
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得sesison回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作;参数:namespace + id
        sqlSession.update("userMapper.update", user);
        // myBatis执行更新操作,需要提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test  // 删除操作
    public void test4() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得sesison回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作;参数:namespace + id
        sqlSession.delete("userMapper.delete", 2);
        // myBatis执行更新操作,需要提交事务
        sqlSession.commit();
        // 释放资源
        sqlSession.close();
    }

    @Test  // 根据id进行查询操作
    public void test5() throws IOException {
        // 获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        // 获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获得sesison回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作;参数:namespace + id
        User user = sqlSession.selectOne("userMapper.findById", 7);
        // 打印数据
        System.out.println(user);
        // 释放资源
        sqlSession.close();
    }
}
