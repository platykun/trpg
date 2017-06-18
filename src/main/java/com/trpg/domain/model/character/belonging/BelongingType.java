package com.trpg.domain.model.character.belonging;

import lombok.Getter;

/**
 * 所持品種別。
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

    /** 所持品種別ID */
    @Getter
    private final int id;

    BelongingType(final int id){
        this.id = id;
    }

    /**
     * 引数のIDに合致した所持品種別オブジェクトを返却する。<br>
     * IDが存在：種別を返却。<br>
     * IDが存在しない：nullを返却。
     *
     * @param id 所持品種別ID
     * @return 所持品種別
     */
    public static BelongingType getType(final int id){
        BelongingType[] types = BelongingType.values();
        for(BelongingType type : types){
            if(type.getId() ==  id){
                return type;
            }
        }
        return null;
    }
}
