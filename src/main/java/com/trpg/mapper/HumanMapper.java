package com.trpg.mapper;

import com.trpg.domain.model.character.belonging.*;
import com.trpg.domain.model.character.character.*;
import com.trpg.domain.model.character.parameter.ParameterList;
import com.trpg.entity.BelongingEntity;
import com.trpg.entity.CharacterInfoEntity;
import com.trpg.entity.HumanEntity;
import org.springframework.stereotype.Repository;

/**
 * Belongingテーブルのマッピングクラス
 */

@Repository
public class HumanMapper {

    private static HumanFactory humanFactory;

    HumanMapper(){
        humanFactory = new HumanFactory();
    }

    public static Human toDetailDomain(HumanEntity humanEntity, CharacterInfoEntity characterInfoEntity) {
        CharacterInfoEntity c = characterInfoEntity;
        HumanEntity h = humanEntity;
        HumanType humanType = HumanType.getType(h.getHumanType());
        Human human = humanFactory.create(
                h.getId(), c.getId(), c.getName(), null, null, null, h.getSchool(), h.getComeFrom(), h.getMentalDisorder(), h.getSex(), h.getAge(), humanType, null
       );
        return human;
    }

    public static Human toDomain(HumanEntity humanEntity, CharacterInfoEntity characterInfoEntity, BelongingList belongingList, ParameterList parameterList, Job job, DetailList detailList){
        CharacterInfoEntity c = characterInfoEntity;
        HumanEntity h = humanEntity;
        HumanType humanType = HumanType.getType(h.getHumanType());

        Human human = humanFactory.create(
                h.getId(), c.getId(), c.getName(),  parameterList, belongingList, job, h.getSchool(), h.getComeFrom(), h.getMentalDisorder(), h.getSex(), h.getAge(), humanType, detailList
        );
        return human;
    }

    /**
     * HumanオブジェクトからHumanEntityを作成する。
     *
     * @param human Humanオブジェクト
     * @return Humanエンティティ
     */
    public static HumanEntity toEntity(Human human){

        int id = human.getHumanId();
        int characterId = human.getHumanId();
        int jobId = human.getJobId();
        String school = human.getSchool();
        String comeFrom = human.getComeFrom();
        String mentalDisorder = human.getMentalDisorder();
        String sex = human.getSex();
        int age = human.getAge();
        int humanType = human.getType().getId();

        HumanEntity humanEntity = new HumanEntity(id, characterId, jobId, school, comeFrom , mentalDisorder, sex, age, humanType);

        return humanEntity;
    }
}
