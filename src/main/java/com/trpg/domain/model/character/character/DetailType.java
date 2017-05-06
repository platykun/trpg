package com.trpg.domain.model.character.character;

import lombok.Getter;

public enum DetailType {
    ADDRESS(0), //住所
    DEPICTION(1), //描写
    FAMILY_FRIENDS(2), //家族&友人
    SYMPTOMS_OF_INSANITY(3), //狂気の症状
    INJURED(4), //負傷
    SCARS(5), //傷跡
    HISTORY(6), //履歴
    INCOME(7), //収入
    CASH_IN_HAND(8), //手持ち現金
    DEPOSIT(9), //預金
    PERSONAL_ASSETS(10), //個人資産
    REAL_ESTATE(11); //不動産

    @Getter
    private final int id;
    
    private DetailType(final int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

    public static DetailType getType(final int id){
        DetailType[] types = DetailType.values();
        for(DetailType type : types){
            return type;
        }
        return null;
    }
}
