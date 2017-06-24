package com.trpg.domain.model.character.character;

import lombok.Getter;

/**
 * キャラクタの詳細ドメインオブジェクト。
 */
public class Detail {
    /** 詳細ID */
    @Getter
    int id;
    /** 詳細種別 */
    @Getter
    DetailType type;
    /** 詳細 */
    @Getter
    String detail;
    
    public Detail(int id, DetailType type, String detail){
        this.id = id;
        this.type = type;
        this.detail = detail;
    }
}
