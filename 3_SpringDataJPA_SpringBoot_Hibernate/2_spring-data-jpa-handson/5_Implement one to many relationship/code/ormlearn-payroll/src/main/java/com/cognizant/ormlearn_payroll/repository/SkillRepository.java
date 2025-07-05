package com.cognizant.ormlearn_payroll.repository;

import com.cognizant.ormlearn_payroll.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
