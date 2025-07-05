package com.cognizant.diff.service;

import com.cognizant.diff.model.Employee;
import com.cognizant.diff.repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaImplementation{
    @Autowired
    private EmployeeRepo employeeRepository;


    public void addEmployee(Employee employee) {
        System.out.println("\n Adding Employee using JPA: " + employee.toString());
        employeeRepository.save(employee);
    }

}
