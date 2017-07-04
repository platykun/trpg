package com.trpg.mapper;

import com.trpg.domain.model.character.character.Job;
import com.trpg.domain.model.character.parameter.InvestigatorSkillType;
import com.trpg.entity.JobDetailEntity;
import com.trpg.entity.JobEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Jobテーブルのマッピングクラス
 */

public class JobMapper {

    /**
     * JobEntityをもとにJobオブジェクトを作成する。<br>
     * 引数にnullが含まれている場合：nullを返却する。
     *
     * @param jobEntity JobEntity
     * @param jobDetailEntityList Job詳細Entityのリスト
     * @return Jobオブジェクト
     */
    public static Job toDomain(JobEntity jobEntity, List<JobDetailEntity> jobDetailEntityList) {

        // nullチェック
        if(jobEntity == null || jobDetailEntityList == null){
            // TODO: 場合によっては例外処理を検討する。
            return null;
        }

        List<InvestigatorSkillType> investigatorSkillTypeList = new ArrayList<>();
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
