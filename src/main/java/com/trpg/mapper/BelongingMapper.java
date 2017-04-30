package com.trpg.mapper;

import com.trpg.domain.model.character.belonging.BelongingFactory;
import com.trpg.domain.model.character.belonging.BelongingType;
import com.trpg.domain.model.character.belonging.WeaponFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.trpg.domain.model.character.belonging.Belonging;
import com.trpg.entity.BelongingEntity;

/**
 * Belongingテーブルのマッピングクラス
 */

public class BelongingMapper {

    BelongingFactory belongingFactory;

    WeaponFactory weaponFactory;

    BelongingMapper(){
        belongingFactory = new BelongingFactory();
    }

    public Belonging toDomain(BelongingEntity belongingEntity) {
        BelongingType belongingType = BelongingType.getType(belongingEntity.getBelongingType());
        Belonging belonging = belongingFactory.createBelonging(belongingType, belongingEntity.getName(), belongingEntity.getDescription());
        return belonging;
    }
}
