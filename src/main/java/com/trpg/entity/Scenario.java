package com.trpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="scenario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {
@Id
private int scenarioId;

//シナリオ本文
private String text;

}
