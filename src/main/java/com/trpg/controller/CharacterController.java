package com.trpg.controller;

import com.trpg.domain.model.character.character.HumanList;
import com.trpg.domain.model.character.character.JobList;
import com.trpg.form.character.CharacterAddForm;
import com.trpg.form.character.CharacterDetailForm;
import com.trpg.helper.CharacterCreateHelper;
import com.trpg.helper.CharacterDetailHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trpg.domain.model.character.character.Human;
import com.trpg.form.character.CharacterTopForm;
import com.trpg.helper.CharacterOutlineHelper;
import com.trpg.service.CharacterService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private CharacterService characterService;

    @Autowired
    CharacterOutlineHelper characterOutlineHelper;

    @Autowired
    CharacterCreateHelper characterCreateHelper;

    @Autowired
    CharacterDetailHelper characterDetailHelper;

    /**
     * キャラクター一覧画面を表示する。
     * 
     * @param model モデル
     * @return トップ画面
     */
    @RequestMapping("/top")
    public String top(Model model) {
        HumanList allOutline = characterService.findAllOutline();
        CharacterTopForm form = characterOutlineHelper.convertToCharacterOutlineForm(allOutline);
        model.addAttribute("characters", form);

        return "character/top";
    }

     /**
     * キャラクター新規追加画面を表示する。
     *
     * @param model モデル
     * @return トップ画面
     */
     @RequestMapping("/add/input")
     public String addInput(Model model) {
         JobList jobList = characterService.getAllJob();
         Human initHuman = characterService.getInitialHuman();

         CharacterAddForm form = characterCreateHelper.convertToCreateForm(initHuman, jobList);
         model.addAttribute("character", form);

         return "character/addInput";
     }

    /**
     * キャラクターを登録する。
     *
     * @param redirectAttributes redirectAttributes
     * @param characterAddForm 入力値
     * @return キャラクター詳細画面
     */
    @RequestMapping("/add/confirm")
    public String addConfirm(RedirectAttributes redirectAttributes, CharacterAddForm characterAddForm){
        //TODO: 登録処理を行う。
        Human human = characterCreateHelper.convertToHuman(characterAddForm);

        // 詳細画面へリダイレクトするためのパラメータを設定する。
        int characterId = characterService.insertHuman(human);
        redirectAttributes.addAttribute("characterId", Integer.valueOf(characterId));

        return "redirect:/character/detail";
    }

     @RequestMapping("/detail")
    public String detail(Model model, Integer characterId){

         Human human = characterService.findHumanByCharacterId(characterId);
         JobList jobList = characterService.getAllJob();
         CharacterDetailForm characterDetailForm = characterDetailHelper.convertToDetailForm(human, jobList);

         model.addAttribute("character", characterDetailForm);

         return "character/detail";
     }

    // /**
    // * キャラクター詳細画面を表示する。
    // *
    // * @param model モデル
    // * @return トップ画面
    // */
    // @RequestMapping("/detail")
    // public String detail(Model model, String id) {
    // CharacterInfo result =
    // characterAction.getCharacter(Integer.parseInt(id));
    // model.addAttribute("character",
    // ParseCharacter.parseCharacterDetail(result));
    //
    // return "character/detail";
    // }
    //
    //
    // /**
    // * キャラクター新規追加画面を表示する。
    // *
    // * @param model モデル
    // * @return トップ画面
    // */
    // @RequestMapping("/add/confirm")
    // public String addConfirm(Model model, CharacterDetailForm character) {
    // CharacterInfo createdCharacter =
    // characterAction.setCharacter(ParseCharacter.parseCharacterInfo(character));
    // model.addAttribute("character", createdCharacter);
    // return "character/detail";
    // }
    //
    // /**
    // * キャラクター編集画面を初期表示させる。
    // *
    // * @param model モデル
    // * @return キャラクター編集画面
    // */
    // @RequestMapping("/update/input")
    // public String updateInput(Model model, int id){
    // //TODO: formで返却する。
    // model.addAttribute("character", characterAction.getCharacter(id));
    // return "character/updateInput";
    // }
    //
    // /**
    // * キャラクターの修正を反映させる。
    // * @param model モデル
    // * @param character 修正後のキャラクター情報
    // * @return 画面
    // */
    // @RequestMapping("/update/confirm")
    // public String updateConfirm(Model model, CharacterDetailForm character){
    // //TODO: formで返却する。
    // CharacterInfo updatedCharacter =
    // characterAction.updateCharacter(ParseCharacter.parseCharacterInfo(character),
    // character.getId());
    // model.addAttribute("character", updatedCharacter);
    // return "character/detail";
    // }

}
