package com.trpg.domain.model.character.belonging;

import lombok.Getter;

import java.util.ArrayList;

/**
 * 所持品リスト。
 * 
 * @author Platykun
 *
 */
public class BelongingList {
    /** 所持品リスト */
    @Getter
    private ArrayList<Belonging> belongings;
    
    BelongingList(){
        belongings = new ArrayList<Belonging>();
    }

    /**
     * 所持品に所持品を追加する。
     * @param belonging 所持品オブジェクト
     * */
    public void add(Belonging belonging){
        belongings.add(belonging);
    }
    
}
