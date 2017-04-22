package com.trpg.domain.model.character.character;

import java.util.ArrayList;

public class DetailList {
    private ArrayList<Detail> detailList;
    
    DetailList(){
        detailList = new ArrayList<Detail>();
    }
    
    public void add(Detail detail){
        //同じDetailTypeのものは追加できない業務ロジックをこのへんに追加する
        detailList.add(detail);
    }
}
