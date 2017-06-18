package com.trpg.domain.model.character.belonging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 所持品リストオブジェクトを作成するファクトリクラス。
 * 
 * @author Platykun
 *
 */
@Component
public class BelongingListFactory {
    /** 所持品ファクトリオブジェクト */
    @Autowired
    private BelongingFactory belongingFactory;

    /**
     * 所持品リストを作成する。
     * @return 所持品リスト
     * */
    public BelongingList create(){
        BelongingList belongingList = new BelongingList();
        return belongingList;
    }

    /**
     * 初期登録用の所持品リストを作成する。
     * TODO: キック組み付きこぶし頭突きを所持品として初期登録させる。
     *
     * @return 初期登録用所持品リスト
     */
    public BelongingList createInitialBelonging(){
        BelongingList belongingList = new BelongingList();
        return belongingList;
    }
}
