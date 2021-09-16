package com.wangyu.domain;

import java.util.List;

/**
 * class VO
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/12 15:34
 **/
public class VO {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
