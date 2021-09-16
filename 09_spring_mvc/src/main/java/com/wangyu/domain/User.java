package com.wangyu.domain;

/**
 * class User
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/11 22:48
 **/
public class User {
    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
