package com.trpg.helper.Character;

import java.util.ArrayList;
import java.util.List;

import com.trpg.domain.model.character.character.HumanList;
import org.springframework.stereotype.Controller;

import com.trpg.domain.model.character.character.Human;
import com.trpg.form.character.common.CharacterOutlineForm;
import com.trpg.form.character.CharacterTopForm;

@Controller
public class CharacterOutlineHelper {
    public CharacterTopForm convertToCharacterOutlineForm(HumanList humanList) {
        List<CharacterOutlineForm> outlineFormList = new ArrayList<CharacterOutlineForm>();

        for(Human human : humanList.getHumans()){
            // TODO: 一覧画面に表示させる内容を確定させる必要がある。
            CharacterOutlineForm characterOutlineForm = new CharacterOutlineForm(human.getCharacterId(), human.getName(), 0);
            outlineFormList.add(characterOutlineForm);
        }
        CharacterTopForm form = new CharacterTopForm(outlineFormList);
        return form;
    }
}
