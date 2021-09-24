package com.wangyu.mapper;

import com.wangyu.domain.Order;

import java.util.List;

/**
 * interface OrderMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/22 21:55
 **/
public interface OrderMapper {
    List<Order> findAll();
}
