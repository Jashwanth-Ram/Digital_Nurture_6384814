package com.cognizant.ormlearn_payroll.service;

import com.cognizant.ormlearn_payroll.model.Skill;

import java.util.List;

public interface SkillService {
    void addSkill(Skill skill);
    Skill getSkill(int id);
    List<Skill> getAllSkills();
}
