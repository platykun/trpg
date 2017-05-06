package com.trpg.domain.model.character.character;

import lombok.Getter;

public class Detail {
    @Getter
    int id;
    @Getter
    DetailType type;
    @Getter
    String detail;
    
    Detail(int id, DetailType type, String detail){
        this.id = id;
        this.type = type;
        this.detail = detail;
    }
}
