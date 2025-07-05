package com.cognizant.ormlearn_payroll.repository;

import com.cognizant.ormlearn_payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
