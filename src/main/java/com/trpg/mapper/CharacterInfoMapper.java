package com.trpg.mapper;

import com.trpg.domain.model.character.character.Character;
import com.trpg.entity.CharacterInfoEntity;

/**
 * CharacterInfoテーブルのマッピングクラス
 */

public class CharacterInfoMapper {

    public static CharacterInfoEntity toEntity(Character character){
        CharacterInfoEntity characterInfoEntity = new CharacterInfoEntity(character.getCharacterId(), character.getName());
        return characterInfoEntity;
    }
}
