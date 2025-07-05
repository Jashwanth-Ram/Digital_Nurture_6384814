package com.cognizant.ormlearn_payroll;

import com.cognizant.ormlearn_payroll.model.*;
import com.cognizant.ormlearn_payroll.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Arrays;

@SpringBootApplication
public class OrmlearnPayrollApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SkillRepository skillRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrmlearnPayrollApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("RUN METHOD STARTED ✅");

        // Step 1: Create and save department
        Department department = new Department();
        department.setName("IT");
        departmentRepository.save(department);

        // Step 2: Create and save skills
        Skill javaSkill = new Skill();
        javaSkill.setName("Java");

        Skill springSkill = new Skill();
        springSkill.setName("Spring Boot");

        skillRepository.saveAll(Arrays.asList(javaSkill, springSkill));

        // Step 3: Create and save employee with department and skills
        Employee employee = new Employee();
        employee.setName("Naveen");
        employee.setSalary(95000);
        employee.setPermanent(true);
        employee.setDateOfBirth(Date.valueOf("1998-11-01"));
        employee.setDepartment(department);
        employee.setSkillList(Arrays.asList(javaSkill, springSkill));

        employeeRepository.save(employee);

        // Step 4: Fetch and print employee
        Employee e = employeeRepository.findById(employee.getId()).get();

        System.out.println("Employee: " + e.getName());
        System.out.println("Department: " + e.getDepartment().getName());
        System.out.println("Skills:");
        e.getSkillList().forEach(s -> System.out.println(" - " + s.getName()));
    }
}
