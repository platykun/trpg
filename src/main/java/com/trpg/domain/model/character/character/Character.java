package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;

public class Character {
    String name;
    ParameterList parameterList;
    BelongingList belongingList;
    
    Character(String name, ParameterList parameterList, BelongingList belongingList){
        this.name = name;
        this.parameterList = parameterList;
        this.belongingList = belongingList;
    }
}
