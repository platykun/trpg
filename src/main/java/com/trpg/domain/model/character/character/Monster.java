package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import lombok.Getter;

/**
 * モンスタードメインオブジェクト。
 */
public class Monster extends Character {
    /** モンスターID */
    @Getter
    private int monsterId;
    /** 装甲 */
    @Getter
    private int armor;
    /** 正気度喪失 */
    @Getter
    private String lackOfSanity;
    /** 備考 */
    @Getter
    private String remarks;

    Monster(int monsterId, int characterId, String name, ParameterList parameterList, BelongingList belongingList, int armor, String lackOfSanity,
            String remarks) {
        super(characterId, name, parameterList, belongingList);
        this.monsterId = monsterId;
        this.armor = armor;
        this.lackOfSanity = lackOfSanity;
        this.remarks = remarks;
    }
}
