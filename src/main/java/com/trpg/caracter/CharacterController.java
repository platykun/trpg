package com.trpg.caracter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trpg.entity.CharacterInfo;
import com.trpg.entity.CharacterInfoRepository;

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
							result.getCharacterId(),
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
		model.addAttribute("character", parseCharacterDetail(result));

		return "character/detail";
	}
	
	/**
	 * キャラクター新規追加画面を表示する。
	 * 
	 * @param model モデル
	 * @return トップ画面
	 */
	@RequestMapping("/add/input")
	public String addInput(Model model, String id) {
		CharacterInfo result = characterAction.getCharacter(Integer.parseInt(id));
		model.addAttribute("character", parseCharacterDetail(result));

		return "character/detail";
	}
	
	/**
	 * characterInfoからキャラクター詳細のformクラスへ変換する。
	 * @param info　キャラクター情報
	 * @return キャラクター詳細情報form
	 */
	private CharacterDetailForm parseCharacterDetail(CharacterInfo info){
		return new CharacterDetailForm(
				info.getCharacterId()
				,info.getName()
				,info.getSchool()
				,info.getComeFrom()
				,info.getMentalDisorder()
				,info.getSex()
				,info.getAge()
				,info.getStr()
				,info.getIntelligence()
				,info.getApp()
				,info.getSiz()
				,info.getDex()
				,info.getCon()
				,info.getPow()
				,info.getEdu()
				,info.getSanityPoint()
				,info.getMagicPoint()
				,info.getDurability()
				);
	}
	
}
