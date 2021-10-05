package com.wangyu.pojo;

/**
 * class Department
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/27 15:00
 **/

// 部门表
public class Department {
    private Integer id;
    private String department;

    public Department() {
    }

    public Department(Integer id, String department) {
        this.id = id;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
