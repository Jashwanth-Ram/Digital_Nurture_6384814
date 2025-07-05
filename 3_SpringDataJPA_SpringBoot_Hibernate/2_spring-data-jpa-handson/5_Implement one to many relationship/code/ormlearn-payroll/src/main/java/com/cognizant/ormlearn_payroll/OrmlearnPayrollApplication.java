package com.cognizant.ormlearn_payroll;
import java.math.BigDecimal;
import com.cognizant.ormlearn_payroll.model.Employee;
import com.cognizant.ormlearn_payroll.model.Department;
import com.cognizant.ormlearn_payroll.service.EmployeeService;
import com.cognizant.ormlearn_payroll.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class OrmlearnPayrollApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnPayrollApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnPayrollApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);

        // Run test methods one at a time
        testAddEmployee();
        // testGetEmployee();
        // testUpdateEmployee();
    }
    private static void testGetDepartment() {
        LOGGER.info("Start");
        Department department = departmentService.get(1); // make sure this ID has employees
        LOGGER.debug("Department: {}", department);
        LOGGER.debug("Employee List: {}", department.getEmployeeList());
        LOGGER.info("End");
    }


    private static void testAddEmployee() {
        LOGGER.info("Start");

        Employee employee = new Employee();
        employee.setName("Naveen");
        employee.setSalary(BigDecimal.valueOf(50000));
        employee.setPermanent(true);
        employee.setDateOfBirth(LocalDate.of(1999, 6, 10));

        Department department = departmentService.get(1);
        employee.setDepartment(department);

        employeeService.save(employee);

        LOGGER.debug("Employee: {}", employee);
        LOGGER.info("End");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());

        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2); // change department
        employee.setDepartment(department);

        employeeService.save(employee);
        LOGGER.debug("Updated Employee: {}", employee);

        LOGGER.info("End");
    }
}
