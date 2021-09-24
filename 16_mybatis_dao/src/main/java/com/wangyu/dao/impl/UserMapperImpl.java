package com.wangyu.dao.impl;

import com.wangyu.dao.UserMapper;
import com.wangyu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * class UserMapperImpl
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 17:26
 **/
//public class UserMapperImpl implements UserMapper {
//    @Override
//    public List<User> findAll() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> userList = sqlSession.selectList("userMapper.findAll");
//        return userList;
//    }
//}
