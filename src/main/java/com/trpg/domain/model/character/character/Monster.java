package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import lombok.Getter;

public class Monster extends Character {
    @Getter
    private int mosterId;
    @Getter
    private int armor; // 装甲
    @Getter
    private String lackOfSanity; // 正気度喪失
    @Getter
    private String remarks; // 備考

    Monster(int monsterId, int characterId, String name, ParameterList parameterList, BelongingList belongingList, int armor, String lackOfSanity,
            String remarks) {
        super(characterId, name, parameterList, belongingList);
        this.mosterId = monsterId;
        this.armor = armor;
        this.lackOfSanity = lackOfSanity;
        this.remarks = remarks;
    }
}
