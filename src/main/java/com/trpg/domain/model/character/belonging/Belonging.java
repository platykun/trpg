package com.trpg.domain.model.character.belonging;

import lombok.Getter;

/**
 * 所持品ドメインオブジェクト。
 * 
 * @author Platykun
 *
 */
public class Belonging{

    /** 所持品ID */
    @Getter
    private int id;

    /** 所持品種別 */
    @Getter
    private BelongingType type;

    /** 名前 */
    @Getter
    private String name;

    /** 説明 */
    @Getter
    private String description;
    
    Belonging(int id, BelongingType type, String name, String description){
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
    }

}
