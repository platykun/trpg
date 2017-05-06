package com.trpg.domain.model.character.character;

import java.util.List;

import com.trpg.domain.model.character.parameter.InvestigatorSkillType;
import lombok.Getter;

public class Job {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private List<InvestigatorSkillType> skillList;
    
    public Job(int id, String name, List<InvestigatorSkillType> skillList){
        this.id = id;
        this.name = name;
        this.skillList = skillList;
    }
}
