package com.wangyu.controller;

import com.wangyu.dao.DepartmentDao;
import com.wangyu.dao.EmployeeDao;
import com.wangyu.pojo.Department;
import com.wangyu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * class EmployeeController
 *
 * @Description //TODO
 * @Author wangyu
 * @Date 2021/9/27 17:28
 **/

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> allEmployees = employeeDao.getAllEmployees();
        model.addAttribute("emps", allEmployees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {
        // 查出所有部门信息
        Collection<Department> departmentList = departmentDao.getDepartmentList();
        model.addAttribute("departments", departmentList);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);  // 保存员工的信息
        return "redirect:/emps";
    }

    // 去员工的修改页面
    @GetMapping("/emp/{id}")
    public String tuUpdateEmp(@PathVariable("id") Integer id, Model model) {
        Employee employeeId = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employeeId);
        Collection<Department> departmentList = departmentDao.getDepartmentList();
        model.addAttribute("departments", departmentList);
        return "emp/update";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        System.out.println("success");
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @RequestMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id) {
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }

}