package com.trpg.domain.model.character.belonging;

import java.util.Map;

/**
 * 所持品の抽象クラス。
 * 所持品のうち、特定種別の所持品のみ機能追加したい場合、
 * 本クラスを継承して機能クラスを作成する。
 * 
 * @author Platykun
 *
 */
public class Belonging {

    private BelongingImpl impl;
    
    Belonging(BelongingImpl impl){
        this.impl = impl;
    }
    
    /**
     * パラメータをmapとして設定する。
     * @return パラメータのマップ
     */
    public Map<String, String> paramMap(){
        return impl.paramMap();
    }
}
