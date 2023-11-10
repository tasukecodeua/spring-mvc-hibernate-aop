package com.selfcode.spring.mvc_hibernate_aop.controller;

import com.selfcode.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.selfcode.spring.mvc_hibernate_aop.entity.Employee;
import com.selfcode.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEpms(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmps();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmp")
    public String addNewEmp(Model model) {
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        return "emp-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmp(@ModelAttribute("emp") Employee employee) {
        employeeService.saveEmps(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEpms(@RequestParam("empId") int id, Model model) {
        Employee employee = employeeService.getEmp(id);
        model.addAttribute("emp", employee);
        return "emp-info";
    }

    @RequestMapping("/deleteEmp")
    public String deleteEmp(@RequestParam("empId")int id) {
        employeeService.deleteEmp(id);
        return "redirect:/";
    }
}
