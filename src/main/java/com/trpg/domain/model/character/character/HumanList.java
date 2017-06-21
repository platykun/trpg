package com.trpg.domain.model.character.character;

import lombok.Getter;

import java.util.ArrayList;

/**
 * 人間ドメインのリスト
 * 
 * @author Platykun
 *
 */
public class HumanList {

    /** 人間ドメインのリスト */
    @Getter
    private ArrayList<Human> humans;

    public HumanList(){
        humans = new ArrayList<>();
    }

    /** 人間ドメインを追加する。 */
    public void add(Human human) {
        humans.add(human);
    }

}
