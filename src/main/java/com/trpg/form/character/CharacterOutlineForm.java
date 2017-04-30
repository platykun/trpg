package com.trpg.form.character;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * キャラクター一覧画面に表示するためのキャラクター概要を格納する。
 * 
 * @author platykun
 *
 */
@Data
@AllArgsConstructor
public class CharacterOutlineForm {

    /** id */
    private int id;

    /** 名前 */
    private String name;

    /** 正気度 */
    private int sanityPoint;

}
