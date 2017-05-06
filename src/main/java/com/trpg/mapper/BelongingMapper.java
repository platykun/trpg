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

    private static BelongingFactory belongingFactory;

    private static WeaponFactory weaponFactory;

    BelongingMapper(){
        belongingFactory = new BelongingFactory();
        weaponFactory = new WeaponFactory();
    }

    public static  Belonging toDomain(BelongingEntity belongingEntity) {
        BelongingType belongingType = BelongingType.getType(belongingEntity.getBelongingType());
        Belonging belonging = belongingFactory.createBelonging(belongingEntity.getId(), belongingType, belongingEntity.getName(), belongingEntity.getDescription());
        return belonging;
    }

    public static BelongingEntity toEntity(Belonging belonging){
        BelongingEntity entity = new BelongingEntity();

        return null;
    }
}
