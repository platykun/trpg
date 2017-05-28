package com.trpg.domain.model.character.belonging;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class BelongingListFactory {

    @Autowired
    private BelongingFactory belongingFactory;

    public BelongingList create(){
        BelongingList belongingList = new BelongingList();
        return belongingList;
    }
    public BelongingList createInitialBelonging(){
        //キック組み付きこぶし頭突きを所持品として初期登録しておきたい。
        BelongingList belongingList = new BelongingList();
        return belongingList;
    }
}
