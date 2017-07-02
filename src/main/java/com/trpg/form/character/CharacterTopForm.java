package com.trpg.form.character;

import java.util.List;

import com.trpg.form.character.common.CharacterOutlineForm;
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
public class CharacterTopForm {

    List<CharacterOutlineForm> outlineList;
}
