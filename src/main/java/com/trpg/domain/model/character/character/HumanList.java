package com.trpg.domain.model.character.character;

import com.trpg.domain.model.character.belonging.Belonging;

import java.util.ArrayList;

/**
 * Humanのリスト
 * 
 * @author Platykun
 *
 */
public class HumanList {

    private ArrayList<Human> humans;

    public HumanList(){
        humans = new ArrayList<Human>();
    }
    
    public void add(Human human) {
        humans.add(human);
    }
}
