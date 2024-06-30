package com.project.project.rest;

import com.project.project.dao.EmployeeDao;
import com.project.project.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {

    private final EmployeeDao employeeDao;

    public Controller(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeDao.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return employeeDao.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeDao.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeDao.findById(employee.getId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());

        return employeeDao.save(employee1);
    }
}
