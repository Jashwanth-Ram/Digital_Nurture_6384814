package com.cognizant.ormlearn_payroll.service.impl;

import com.cognizant.ormlearn_payroll.model.Skill;
import com.cognizant.ormlearn_payroll.repository.SkillRepository;
import com.cognizant.ormlearn_payroll.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public void addSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public Skill getSkill(int id) {
        return skillRepository.findById(id).orElse(null);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}
