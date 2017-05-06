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

    public static HumanEntity toEntity(Human human){

        return null;
    }
}
