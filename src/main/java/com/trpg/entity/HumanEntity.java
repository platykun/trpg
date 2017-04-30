package com.trpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "human")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HumanEntity {
    @Id
    @GeneratedValue
    private int id;

    private int characterId;

    private int jobId;

    private String school;

    private String comeFrom;

    private String mentalDisorder;

    private String sex;

    private int age;
}
