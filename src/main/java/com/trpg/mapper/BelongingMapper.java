package com.trpg.mapper;

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

    Belonging toDomain(BelongingEntity belongingEntity) {
        return null;
    }

    @Id
    @GeneratedValue
    private int id;

    private int characterId;

    private int belongingType;

    private String name;
}
