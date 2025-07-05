package com.cognizant.ormlearn_payroll;

import com.cognizant.ormlearn_payroll.model.Department;
import com.cognizant.ormlearn_payroll.model.Employee;
import com.cognizant.ormlearn_payroll.model.Skill;
import com.cognizant.ormlearn_payroll.service.DepartmentService;
import com.cognizant.ormlearn_payroll.service.EmployeeService;
import com.cognizant.ormlearn_payroll.service.SkillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class OrmlearnPayrollApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnPayrollApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnPayrollApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        // Comment/uncomment methods below based on what you want to test
        // testGetEmployee();
        testAddSkillToEmployee();
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1); // Ensure employee with ID 1 exists
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());
        LOGGER.debug("Skills: {}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Skill skill = skillService.getSkill(2); // 🔁 use getSkill()

        Set<Skill> skills = employee.getSkillList();
        skills.add(skill);
        employee.setSkillList(skills);

        employeeService.save(employee);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.info("End");
    }

}
