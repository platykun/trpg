package com.trpg.mapper;

import com.trpg.domain.model.character.character.DetailList;
import com.trpg.domain.model.character.character.Job;
import com.trpg.domain.model.character.parameter.InvestigatorSkillType;
import com.trpg.entity.DetailEntity;
import com.trpg.entity.JobDetailEntity;
import com.trpg.entity.JobEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Jobテーブルのマッピングクラス
 */

public class JobMapper {
//    public static Job toDomain(JobEntity jobEntity, List<InvestigatorSkillType> investigatorSkillTypeList) {
//        Job job = new Job(jobEntity.getId(), jobEntity.getName(), investigatorSkillTypeList);
//        return job;
//    }

    public static Job toDomain(JobEntity jobEntity, List<JobDetailEntity> jobDetailEntityList) {
        List<InvestigatorSkillType> investigatorSkillTypeList = new ArrayList<InvestigatorSkillType>();
        for(JobDetailEntity jobDetailEnttiy : jobDetailEntityList){
            InvestigatorSkillType investigatorSkillType = InvestigatorSkillType.getType(jobDetailEnttiy.getInvestigateType());
            investigatorSkillTypeList.add(jobDetailEnttiy.getId(), investigatorSkillType);
        }
        Job job = new Job(jobEntity.getId(), jobEntity.getName(), investigatorSkillTypeList);
        return job;
    }

    public static JobEntity toEntity(Job job){
        JobEntity jobEntity = new JobEntity(job.getId(), job.getName());
        return jobEntity;
    }
}
