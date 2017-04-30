package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import lombok.Getter;

public class Character {
    @Getter
    String name;
    @Getter
    ParameterList parameterList;
    @Getter
    BelongingList belongingList;
    
    Character(String name, ParameterList parameterList, BelongingList belongingList){
        this.name = name;
        this.parameterList = parameterList;
        this.belongingList = belongingList;
    }
}
