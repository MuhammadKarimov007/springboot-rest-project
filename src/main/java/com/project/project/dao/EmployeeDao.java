package com.project.project.dao;

import com.project.project.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployees();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
