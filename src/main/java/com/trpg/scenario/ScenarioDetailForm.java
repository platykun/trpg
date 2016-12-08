package com.trpg.scenario;

import java.util.List;

import com.trpg.caracter.CharacterDetailForm;
import com.trpg.entity.Scenario;

import lombok.Data;

/**
 * シナリオの詳細を格納する。
 * 
 * @author platykun
 *
 */
@Data
public class ScenarioDetailForm {
	/** シナリオ */
	Scenario scenario;
	
	/** 本文 */
	String text;
	
	/** NPCのリスト */
	List<CharacterDetailForm> npcs;
	
	/** 敵のリスト */
	List<CharacterDetailForm> enemies;
}
