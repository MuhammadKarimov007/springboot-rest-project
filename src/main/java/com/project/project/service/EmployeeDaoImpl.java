package com.project.project.service;

import com.project.project.dao.EmployeeDao;
import com.project.project.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Transactional
    @Override
    public Employee deleteById(int id) {
        Employee removeEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(removeEmployee);
        return removeEmployee;
    }
}
