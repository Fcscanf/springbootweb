package cn.fcsca.controller;

import cn.fcsca.dao.DepartmentDao;
import cn.fcsca.dao.EmployeeDao;
import cn.fcsca.entities.Department;
import cn.fcsca.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * EmployeeController
 *
 * @author Fcscanf@樊乘乘
 * @description
 * @date 下午 18:40 2018-08-12
 */
@Controller
public class EmployeeController {

    /**
     * 自动注入  
     */
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 自动注入
     */
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 查询所有员工列表 
     *
     * @param model
     * @return 
     * @author Fcscanf@樊乘乘
     * @date 下午 18:42 2018-08-12 
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    /**
     * 跳转到员工添加页面 
     *
     * @param model
     * @return 
     * @author Fcscanf@樊乘乘
     * @date 下午 20:32 2018-08-12 
     */
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //在转发到添加页面时查出部门信息显示到下拉列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    /**
     * 员工添加
     *
     * @param employee
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 21:37 2018-08-12 
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println("添加的员工信息：" + employee);
        employeeDao.save(employee);
        //员工添加完成返回到员工列表页面
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工的信息，在修改页面回显 
     *
     * @param id
     * @param model
     * @return
     * @author Fcscanf@樊乘乘
     * @date 下午 22:03 2018-08-12 
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //在转发到添加页面时查出部门信息显示到下拉列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面，可以使用ADD页面，只是该页面应该有员工的数据
        return "emp/add";
    }

    /**
     * 员工修改 
     *
     * @param
     * @return 
     * @author Fcscanf@樊乘乘
     * @date 下午 22:39 2018-08-12 
     */
    @PutMapping("/emp")
    public String updateEmployyee(Employee employee) {
        System.out.println("修改的员工信息：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除 
     *
     * @param id
     * @return 
     * @author Fcscanf@樊乘乘
     * @date 下午 22:51 2018-08-12 
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
