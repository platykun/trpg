package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import lombok.Getter;

/**
 * キャラクタードメインオブジェクト。
 */
public class Character {

    /** キャラクタID */
    @Getter
    private int characterId;
    /** キャラクタ名 */
    @Getter
    private String name;
    /** パラメータリスト */
    @Getter
    private ParameterList parameterList;
    /** 所持品リスト */
    @Getter
    private BelongingList belongingList;
    
    Character(int characterId, String name, ParameterList parameterList, BelongingList belongingList){
        this.characterId = characterId;
        this.name = name;
        this.parameterList = parameterList;
        this.belongingList = belongingList;
    }
}
