package com.trpg.domain.model.character.character;

import lombok.Getter;

/**
 * 人間種別。
 *
 * @author Platykun
 *
 */
public enum HumanType {
    SEARCHER(0), //探索者
    NPC(1); //NPC

    /** 人間種別ID */
    @Getter
    private final int id;
    
    HumanType(final int id){
        this.id = id;
    }

    /**
     * 引数のIDに合致した人間種別オブジェクトを返却する。<br>
     * IDが存在：種別を返却。<br>
     * IDが存在しない：nullを返却。
     *
     * @param id 人間種別ID
     * @return 人間種別
     */
    public static HumanType getType(final int id){
        HumanType[] types = HumanType.values();
        for(HumanType type : types){
            if(type.getId() == id){
                return type;
            }
        }
        return null;
    }
}
