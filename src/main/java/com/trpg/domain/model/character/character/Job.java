package com.trpg.domain.model.character.character;

import java.util.List;

import com.trpg.domain.model.character.parameter.InvestigatorSkillType;

public class Job {
    private String name;
    private List<InvestigatorSkillType> skillList;
    
    Job(String name, List<InvestigatorSkillType> skillList){
        this.name = name;
        this.skillList = skillList;
    }
}
