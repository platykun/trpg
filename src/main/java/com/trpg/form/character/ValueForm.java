package com.trpg.form.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * キャラクター一覧画面に表示するためのキャラクター概要を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValueForm {

    /** パラメータID */
    private int paramId;

    /** パラメータサブID */
    private int paramSubId;

    /** 値 */
    private int value;

    /** 文字値 */
    private String stringValue;

    /** 名前 */
    private String name;

    /** 初期値 */
    private int initValue;

}
