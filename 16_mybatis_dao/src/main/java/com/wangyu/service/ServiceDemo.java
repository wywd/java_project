package com.wangyu.service;

import com.wangyu.dao.UserMapper;
//import com.wangyu.dao.impl.UserMapperImpl;
import com.wangyu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * class ServiceDemo
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 17:30
 **/
public class ServiceDemo {
    public static void main(String[] args) throws IOException {
        // 创建Dao对象
//        UserMapper userMapper = new UserMapperImpl();
//        List<User> userList = userMapper.findAll();
//        System.out.println(userList);
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        System.out.println(userList);

        User user = mapper.findById(5);
        System.out.println(user);
    }
}
