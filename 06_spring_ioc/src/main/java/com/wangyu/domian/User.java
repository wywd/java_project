package com.wangyu.domian;

/**
 * class User
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/10 15:39
 **/
public class User {
    private String name;
    private String addr;

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
