package com.wangyu;

import com.wangyu.domain.User;
import com.wangyu.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
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
 * @Date 2021/9/23 19:24
 **/
public class MyBatisTest {
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("asdf");
        user.setBirthday(new Date());
        mapper.save(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(10);
        user.setUsername("Lucy");
        user.setPassword("lucy233");
        user.setBirthday(new Date());
        mapper.update(user);
    }

    @Test
    public void testDelete() {
        mapper.delete(11);
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(6);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void test3() {
        List<User> userAndOrderAll = mapper.findUserAndOrderAll();
        for (User user : userAndOrderAll) {
            System.out.println(user);
        }
    }
}
