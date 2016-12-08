package com.trpg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "related_character")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelatedCharacter {
	
	/** ID */
	@Id
	@GeneratedValue
	private int id;
	/** シナリオID */
	private int scenarioId;
	/** キャラクターID */
	private int characterInfoId;
	/** カテゴリ */
	private int category;
}
