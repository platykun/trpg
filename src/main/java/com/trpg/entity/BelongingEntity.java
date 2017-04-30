package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Belongingテーブルのエンティティクラス
 */

@Entity
@Table(name = "belonging")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BelongingEntity {
    @Id
    @GeneratedValue
    private int id;

    private int characterId;

    private int belongingType;

    private String name;

    private String description;
}
