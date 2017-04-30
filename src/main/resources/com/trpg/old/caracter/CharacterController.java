package com.trpg.caracter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trpg.entity.CharacterInfo;

/**
 * キャラクター管理を行う画面のコントローラクラス
 * 
 * @author platykun
 *
 */
@Controller
@RequestMapping("/character")
public class CharacterController {

	@Autowired
	private CharacterAction characterAction;

	/**
	 * キャラクター一覧画面を表示する。
	 * 
	 * @param model モデル
	 * @return トップ画面
	 */
	@RequestMapping("/top")
	public String top(Model model) {
		List<CharacterInfo> results = characterAction.getCharacterList();
		List<CharacterOutlineForm> characters = new ArrayList<CharacterOutlineForm>();
		results.stream().forEach(result -> characters.add(
					    new CharacterOutlineForm(
							result.getId(),
						    result.getName(), 
						    result.getSanityPoint()))
						);
		model.addAttribute("characters", characters);

		return "character/top";
	}

	/**
	 * キャラクター詳細画面を表示する。
	 * 
	 * @param model モデル
	 * @return トップ画面
	 */
	@RequestMapping("/detail")
	public String detail(Model model, String id) {
		CharacterInfo result = characterAction.getCharacter(Integer.parseInt(id));
		model.addAttribute("character", ParseCharacter.parseCharacterDetail(result));

		return "character/detail";
	}
	
	/**
	 * キャラクター新規追加画面を表示する。
	 * 
	 * @param model モデル
	 * @return トップ画面
	 */
	@RequestMapping("/add/input")
	public String addInput(Model model) {
		model.addAttribute("character", new CharacterDetailForm());
		return "character/addInput";
	}
	
	/**
	 * キャラクター新規追加画面を表示する。
	 * 
	 * @param model モデル
	 * @return トップ画面
	 */
	@RequestMapping("/add/confirm")
	public String addConfirm(Model model, CharacterDetailForm character) {
		CharacterInfo createdCharacter = characterAction.setCharacter(ParseCharacter.parseCharacterInfo(character));
		model.addAttribute("character", createdCharacter);
		return "character/detail";
	}

	/**
	 * キャラクター編集画面を初期表示させる。
	 *
	 * @param model モデル
	 * @return キャラクター編集画面
	 */
	@RequestMapping("/update/input")
	public String updateInput(Model model, int id){
		//TODO: formで返却する。
		model.addAttribute("character", characterAction.getCharacter(id));
		return "character/updateInput";
	}
	
	/**
	 * キャラクターの修正を反映させる。
	 * @param model モデル
	 * @param character 修正後のキャラクター情報
	 * @return 画面
	 */
	@RequestMapping("/update/confirm")
	public String updateConfirm(Model model, CharacterDetailForm character){
		//TODO: formで返却する。
		CharacterInfo updatedCharacter = characterAction.updateCharacter(ParseCharacter.parseCharacterInfo(character), character.getId());
		model.addAttribute("character", updatedCharacter);
		return "character/detail";
	}
	
}
