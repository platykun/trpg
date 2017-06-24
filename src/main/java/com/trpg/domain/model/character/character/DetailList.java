package com.trpg.domain.model.character.character;

import lombok.Getter;

import java.util.ArrayList;

/**
 * キャラクタの詳細リスト。
 */
public class DetailList {
    /** 詳細リスト */
    @Getter
    private ArrayList<Detail> detailList;
    
    public DetailList(){
        detailList = new ArrayList<Detail>();
    }

    /**
     * 詳細を追加する。
     *
     * @param detail 追加対象の詳細ドメインオブジェクト
     */
    public void add(Detail detail){
        //TODO: 同じDetailTypeのものは追加できない業務ロジックをこのへんに追加する
        detailList.add(detail);
    }
}
