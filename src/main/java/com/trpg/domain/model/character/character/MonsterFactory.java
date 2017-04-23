package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;

public class MonsterFactory{
    public Monster create(String name, ParameterList parameterList, BelongingList belongingList, int armor,
            String lackOfSanity, String remarks) {
        Monster monster = new Monster(name, parameterList, belongingList, armor, lackOfSanity, remarks);
        return monster;
    }
}
