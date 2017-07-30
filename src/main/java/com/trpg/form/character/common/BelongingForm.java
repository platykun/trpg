package com.trpg.form.character.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 所持品情報を格納するFormクラス。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BelongingForm {

    /** 所持品ID */
    private int id;

    /** 名前 */
    private String name;

    /** 説明 */
    private String description;

    /** 所持品種別 */
    private int belongingType;
}
