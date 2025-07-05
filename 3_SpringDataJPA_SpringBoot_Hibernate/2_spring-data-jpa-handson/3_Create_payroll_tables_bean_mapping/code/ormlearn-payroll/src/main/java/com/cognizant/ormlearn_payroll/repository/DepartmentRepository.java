package com.cognizant.ormlearn_payroll.repository;

import com.cognizant.ormlearn_payroll.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
