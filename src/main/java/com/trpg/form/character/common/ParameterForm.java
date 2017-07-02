package com.trpg.form.character.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * パラメータ情報を格納するFormクラス。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParameterForm {

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

    /** リネーム可能かどうかのフラグ */
    //private boolean canRename;

}
