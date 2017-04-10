package com.trpg.domain.model.character.belonging;

import java.util.ArrayList;
import java.util.Map;

import groovyjarjarantlr.collections.List;

/**
 * 所持品の抽象クラス。
 * 所持品のうち、特定種別の所持品のみ機能追加したい場合、
 * 本クラスを継承して機能クラスを作成する。
 * 
 * @author Platykun
 *
 */
public class BelongingList {

    private ArrayList<Belonging> belongings;
    
    BelongingList(){
        belongings = new ArrayList<Belonging>();
    }
    
    public void add(Belonging belonging){
        belongings.add(belonging);
    }
    
    public ArrayList<Map<String, String>> pramMaps(){
        ArrayList<Map<String, String>> paramMaps =new ArrayList<Map<String, String>>();
        belongings.stream().forEach(b -> paramMaps.add(b.paramMap()));
        return paramMaps;
    }
    
}
