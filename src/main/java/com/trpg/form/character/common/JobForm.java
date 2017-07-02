package com.trpg.form.character.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * キャラクター一覧画面に表示するためのキャラクター概要を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobForm {

    /** 職業ID */
    private int id;

    /** 職業名 */
    private String name;

    /** 技能リスト */
    private List<Integer> skillList;

}
