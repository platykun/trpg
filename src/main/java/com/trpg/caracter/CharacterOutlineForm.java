package com.trpg.caracter;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * キャラクター一覧画面に表示するためのキャラクター概要を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
public class CharacterOutlineForm {
	private int id;
	private String name;
	private int sanityPoint;
	
}
