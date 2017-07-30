package com.trpg.mapper;

import com.trpg.domain.model.character.belonging.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trpg.entity.BelongingEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Belongingテーブルのマッピングクラス
 */

public class BelongingMapper {


    private static BelongingFactory belongingFactory = new BelongingFactory();

    BelongingMapper(){
        //belongingFactory = new BelongingFactory();
    }

    public static  Belonging toDomain(BelongingEntity belongingEntity) {
        BelongingType belongingType = BelongingType.getType(belongingEntity.getBelongingType());
        int id = belongingEntity.getId();
        String name = belongingEntity.getName();
        String description = belongingEntity.getDescription();
        Belonging belonging = belongingFactory.createBelonging(id, belongingType, name, description);
        return belonging;
    }

    public static BelongingEntity toEntity(int characterId, Belonging belonging){
        int id = belonging.getId();
        int belongingType = belonging.getType().getId();
        String name = belonging.getName();
        String description = belonging.getDescription();

        return new BelongingEntity(id, characterId, belongingType, name, description);
    }
}
