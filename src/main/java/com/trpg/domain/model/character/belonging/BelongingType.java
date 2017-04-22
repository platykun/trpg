package com.trpg.domain.model.character.belonging;

/**
 * 所持品種別
 * 
 * @author platykun
 */
public enum BelongingType {
    WEAPONS(0), //武器
    SPELL(1), //呪文
    ARTIFACT(2),  //アーティファクト
    MAGICAL_BOOK(3), //魔導書
    ITEM(4), //持ち物
    SUPERNATURAL(5); //遭遇した超自然の存在
    private final int id;
    
    private BelongingType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
}
