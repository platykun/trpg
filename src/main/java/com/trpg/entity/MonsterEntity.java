package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Monsterテーブルのエンティティクラス
 */

@Entity
@Table(name = "monster")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonsterEntity{
    @Id
    @GeneratedValue
    private int id;

    private int characterID;

    private int armor;

    private String lackOfSanity;

    private String remarks;
}
