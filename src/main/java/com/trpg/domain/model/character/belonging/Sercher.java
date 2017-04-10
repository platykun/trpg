package com.trpg.domain.model.character.belonging;

/**
 * TODO:builderパターンを使用して実装する。
 * 
 * @author Platykun
 *
 */
public class Sercher {
    BelongingType type;
    
    String name;
    
    String description;
    
    Sercher(BelongingType type, String name, String description){
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
