package com.wangyu.service;

import com.wangyu.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * interface AccountService
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/23 23:26
 **/
public interface AccountService {
    void save(Account account);
    List<Account> findAll();
}
