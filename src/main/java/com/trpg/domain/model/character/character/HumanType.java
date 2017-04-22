package com.trpg.domain.model.character.character;

/**
 * 人間種別
 * @author Platykun
 *
 */
public enum HumanType {
    SEARCHER(0), //探索者
    NPC(1); //NPC
    
    private final int id;
    
    private HumanType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
