package com.trpg.scenario;

import java.util.List;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.Scenario;

import lombok.Data;

/**
 * シナリオの詳細を格納する。
 * 
 * @author platykun
 *
 */
@Data
public class ScenarioDetail {
	/** シナリオ */
	Scenario scenario;
	
	/** 本文 */
	String text;
	
	/** NPCのリスト */
	List<CharacterInfo> npcs;
	
	/** 敵のリスト */
	List<CharacterInfo> enemies;
}
