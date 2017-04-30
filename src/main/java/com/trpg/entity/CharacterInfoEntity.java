package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CHARACTER_INFOテーブルのエンティティクラス
 */

@Entity
@Table(name = "character_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterInfoEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;
}
