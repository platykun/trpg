package com.trpg.common;

import com.trpg.caracter.CharacterDetailForm;
import com.trpg.entity.CharacterInfo;

/**
 * formクラスとEntityクラスの変換を行う。
 * 
 * @author platykun
 *
 */
public final class ParseCharacter {
	/**
	 * characterInfoからキャラクター詳細のformクラスへ変換する。
	 * @param info　キャラクター情報
	 * @return キャラクター詳細情報form
	 */
	public static CharacterDetailForm parseCharacterDetail(CharacterInfo info){
		return new CharacterDetailForm(
				info.getId()
				,info.getName()
				,info.getSchool()
				,info.getComeFrom()
				,info.getMentalDisorder()
				,info.getSex()
				,info.getAge()
				,info.getStr()
				,info.getIntelligence()
				,info.getApp()
				,info.getSiz()
				,info.getDex()
				,info.getCon()
				,info.getPow()
				,info.getEdu()
				,info.getSanityPoint()
				,info.getMagicPoint()
				,info.getDurability()
				);
	}
	
	/**
	 * characterDetailFormからcharacterInfoへ変換する。
	 * @param info Formクラス
	 * @return キャラクター情報クラス
	 */
	public static CharacterInfo parseCharacterInfo(CharacterDetailForm info){
		return new CharacterInfo(
				info.getId()
				,info.getName()
				,info.getSchool()
				,info.getComeFrom()
				,info.getMentalDisorder()
				,info.getSex()
				,info.getAge()
				,info.getStr()
				,info.getIntelligence()
				,info.getApp()
				,info.getSiz()
				,info.getDex()
				,info.getCon()
				,info.getPow()
				,info.getEdu()
				,info.getSanityPoint()
				,info.getMagicPoint()
				,info.getDurability()
				);
	}
}
