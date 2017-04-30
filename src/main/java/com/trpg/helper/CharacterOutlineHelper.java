package com.trpg.helper;

import java.util.ArrayList;
import java.util.List;

import com.trpg.domain.model.character.character.HumanList;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.trpg.domain.model.character.character.Human;
import com.trpg.form.character.CharacterOutlineForm;
import com.trpg.form.character.CharacterOutlineListForm;

@Controller
public class CharacterOutlineHelper {
    public CharacterOutlineListForm convertToCharacterOutlineForm(HumanList humanList) {
        List<CharacterOutlineForm> outlineFormList = new ArrayList<CharacterOutlineForm>();

        for(Human human : humanList.getHumans()){
            CharacterOutlineForm characterOutlineForm = new CharacterOutlineForm(0, human.getName(), 0);
            outlineFormList.add(characterOutlineForm);
        }
        CharacterOutlineListForm form = new CharacterOutlineListForm(outlineFormList);
        return form;
    }
}
