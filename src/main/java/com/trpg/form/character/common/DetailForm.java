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

    private int id;

    private int detailType;

    private String detail;
}
