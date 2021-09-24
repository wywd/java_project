package com.wangyu.mapper;

import com.wangyu.domain.Order;
import com.wangyu.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * interface OrderMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/23 19:54
 **/
public interface OrderMapper {
//    @Select("select *, o.id oid from orders o, user u where o.uid=u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//    })

    @Select("select * from orders")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    javaType = User.class,  // 要封装的实体类型
                    property = "user",  // 要封装的属性名称是谁
                    column = "uid",  // 根据哪个字段查询user表数据
                    // select属性,表示查询哪个接口的方法去获得数据
                    one = @One(select = "com.wangyu.mapper.UserMapper.findById")
            )
    })
    List<Order> findAll();

    @Select("select * from orders where uid=#{uid}")
    List<Order> findByUid(int uid);
}
