package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.BelongingList;
import com.trpg.domain.model.character.parameter.ParameterList;
import lombok.Getter;

public class Character {
    @Getter
    private int characterId;
    @Getter
    private String name;
    @Getter
    private ParameterList parameterList;
    @Getter
    private BelongingList belongingList;
    
    Character(int characterId, String name, ParameterList parameterList, BelongingList belongingList){
        this.characterId = characterId;
        this.name = name;
        this.parameterList = parameterList;
        this.belongingList = belongingList;
    }
}
