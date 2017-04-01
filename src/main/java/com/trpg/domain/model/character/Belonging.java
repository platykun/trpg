package com.trpg.domain.model.character;

/**
 * 所持品
 * 
 * @author Platykun
 *
 */
public class Belonging {
    BelongingType type;
    
    String name;
    
    String description;
    
    Belonging(BelongingType type, String name, String description){
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
