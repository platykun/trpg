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

    /** ID */
    private int id;

    /** パラメータID */
    private int parameterTypeId;

    /** パラメータサブID */
    private int paramSubTypeId;

    /** 値 */
    private int parameterValue;

    /** 文字値 */
    private String stringValue;

    /** 名前 */
    private String name;

    /** 初期値 */
    private int initValue;

    /** リネーム可能かどうかのフラグ */
    //private boolean canRename;

}
