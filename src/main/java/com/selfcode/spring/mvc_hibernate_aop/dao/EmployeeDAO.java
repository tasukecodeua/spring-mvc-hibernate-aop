package com.selfcode.spring.mvc_hibernate_aop.dao;

import com.selfcode.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmps();

    public void saveEmps(Employee employee);

    public Employee getEmp(int id);

    void deleteEmp(int id);
}
