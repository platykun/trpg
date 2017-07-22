package com.trpg.mapper;

import com.trpg.domain.model.character.character.Detail;
import com.trpg.domain.model.character.character.DetailList;
import com.trpg.domain.model.character.character.Job;
import com.trpg.domain.model.character.parameter.InvestigatorSkillType;
import com.trpg.entity.DetailEntity;
import com.trpg.entity.JobDetailEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * JobDetailテーブルのマッピングクラス
 */

public class JobDetailMapper {
    public static List<JobDetailEntity> toEntity(Job job){
        int jobId = job.getId();
        List<JobDetailEntity> entityList = new ArrayList<JobDetailEntity>();

        List<InvestigatorSkillType> skillList = job.getSkillList();
        for(InvestigatorSkillType skill : skillList){
            JobDetailEntity entity = new JobDetailEntity(0, jobId, skill.getId());
            entityList.add(entity);
        }
        return entityList;
    }
}
