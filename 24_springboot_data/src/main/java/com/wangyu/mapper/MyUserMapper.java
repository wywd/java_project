package com.wangyu.mapper;

import com.wangyu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * interface UserMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/30 18:13
 **/

@Mapper  // 表示这是一个mabatis的mapper类,Dao层
@Repository
public interface MyUserMapper {
    public static final int age = 18;
    List<User> queryUserList();
    User queryUserById();
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}

