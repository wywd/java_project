package com.wangyu.mapper;

import com.wangyu.domain.Account;

import java.util.List;

/**
 * interface AccountMapper
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/23 23:25
 **/
public interface AccountMapper {
    void save(Account account);
    List<Account> findAll();
}
