package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;

public class Monster extends Character {
    private int armor; // 装甲
    private String lackOfSanity; // 正気度喪失
    private String remarks; // 備考

    Monster(String name, ParameterList parameterList, BelongingList belongingList, int armor, String lackOfSanity,
            String remarks) {
        super(name, parameterList, belongingList);
        this.armor = armor;
        this.lackOfSanity = lackOfSanity;
        this.remarks = remarks;
    }
}
