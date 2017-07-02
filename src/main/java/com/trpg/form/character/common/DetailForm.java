package com.trpg.form.character.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 詳細情報を格納するフォームクラス。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailForm {

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
