package com.trpg.scenario;

import java.util.List;

import com.trpg.entity.CharacterInfo;

import com.trpg.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * アイテムの詳細を格納する。
 * 
 * @author platykun
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemForm {
	/** アイテムID */
	private int id;
	/** シナリオID */
	private int scenarioId;
	/** シーンID */
	private int sceneId;
	/** 連番 */
	private int serialNum;
	/** 名前 */
	private String name;
	/** 画像URL */
	private String imgUrl;
	/** 内容 */
	private String text;

    /**
     * アイテムエンティティとして返却
     *
     * @return item
     */
	public Item convertItem(){
	    Item item = new Item();
	    item.setId(id);
	    item.setScenarioId(scenarioId);
	    item.setSceneId(sceneId);
	    item.setSerialNum(serialNum);
	    item.setImgUrl(imgUrl);
	    item.setText(text);
	    //item.setName(name);何故か存在しない
		return item;
	}

    /**
     * itemの内容をformへ格納する。
     *
     * @param item　アイテムエンティティ
     * @return 格納後のformクラス
     */
	public ItemForm setItem(Item item){
	    id = item.getId();
	    scenarioId = item.getScenarioId();
	    sceneId = item.getSceneId();
	    serialNum = item.getSerialNum();
	    name = "エンティティクラスで存在しないため要修正";
	    imgUrl = item.getImgUrl();
	    text = item.getText();
	    return this;
    }
}
