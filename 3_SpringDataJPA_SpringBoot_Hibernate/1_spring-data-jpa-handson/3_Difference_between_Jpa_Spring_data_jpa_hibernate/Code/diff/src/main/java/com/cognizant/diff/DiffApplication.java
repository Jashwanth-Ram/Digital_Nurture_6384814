package com.cognizant.diff;

import com.cognizant.diff.model.Employee;
import com.cognizant.diff.service.HibernateImplementation;
import com.cognizant.diff.service.JpaImplementation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiffApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DiffApplication.class, args);
        Employee employee = new Employee("1235", "John Doe", "Engineering", 75000.0);
        JpaImplementation jpaImplementation = context.getBean(JpaImplementation.class);
        jpaImplementation.addEmployee(employee);
        HibernateImplementation hb = new HibernateImplementation();
        Employee employee1 = new Employee("1249", "Alex","Support",30000.0);
        hb.HibernateImplementationsave(employee1);
    }

}
