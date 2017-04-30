package com.trpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DETAILテーブルのエンティティクラス
 */

@Entity
@Table(name = "detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailEntity {
    @Id
    @GeneratedValue
    private int id;

    private int characterId;

    private int detailType;

    private String detail;

}
