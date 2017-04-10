package com.trpg.domain.model.character.belonging;

import java.util.ArrayList;
import java.util.Map;

/**
 * 所持品オブジェクトを作成する
 * 
 * @author Platykun
 *
 */
public class BelongingListFactory {
    BelongingList create(ArrayList<Map<String, String>> paramMaps) {
        BelongingList belongingList = new BelongingList();
        BelongingFactory factory = new BelongingFactory();
        paramMaps.stream().forEach(p -> belongingList.add(factory.create(p)));

        return belongingList;
    }
}
