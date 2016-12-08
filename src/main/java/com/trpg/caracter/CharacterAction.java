package com.trpg.caracter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.CharacterInfoRepository;

@Controller
public class CharacterAction {

	@Autowired
	CharacterInfoRepository characterInfoRepository;

	/**
	 * 作成したキャラクターの一覧を表示する。
	 * 
	 * @return キャラクター情報一覧
	 */
	List<CharacterInfo> getCharacterList() {
		return characterInfoRepository.findAll();
	}

	/**
	 * idを指定してキャラクターを取得する。
	 * 
	 * @param id　キャラクターID
	 * @return idに合致するキャラクター情報
	 */
	CharacterInfo getCharacter(int id) {
		return characterInfoRepository.findOne(id);
	}
	
	/**
	 * キャラクターを登録する。
	 * 
	 * @param character キャラクター情報詳細
	 * @return 登録後のキャラクター情報
	 */
	CharacterInfo setCharacter(CharacterInfo character){
		//idが重複していないことを確認
		return characterInfoRepository.save(character);
	}

}
