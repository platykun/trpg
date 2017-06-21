package com.trpg.domain.model.character.character;

import java.util.List;

import com.trpg.domain.model.character.parameter.InvestigatorSkillType;
import lombok.Getter;

/**
 * 職業ドメインオブジェクト。
 */
public class Job {
    /** 職業ID */
    @Getter
    private int id;
    /** 職業名 */
    @Getter
    private String name;
    /** 個人的に興味のあるスキル */
    @Getter
    private List<InvestigatorSkillType> skillList;
    
    public Job(int id, String name, List<InvestigatorSkillType> skillList){
        this.id = id;
        this.name = name;
        this.skillList = skillList;
    }
}
