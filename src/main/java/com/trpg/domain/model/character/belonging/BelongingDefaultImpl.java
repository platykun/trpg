package com.trpg.domain.model.character.belonging;

import java.util.HashMap;
import java.util.Map;

/**
 * 所持品のデフォルトの実装クラス
 * 
 * @author Platykun
 *
 */
public class BelongingDefaultImpl extends BelongingImpl{
    
    BelongingType type;
    String name;
    String description;
    
    BelongingDefaultImpl(BelongingType type, String name, String description){
        this.type = type;
        this.name = name;
        this.description = description;
    }
    
    /**
     * パラメータをmapとして設定する。
     * @return パラメータのマップ
     */
    @Override
    public Map<String, String> paramMap(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("belongingType", type.toString());
        map.put("name", name);
        map.put("description", description);
        
        return map;
    }
}
