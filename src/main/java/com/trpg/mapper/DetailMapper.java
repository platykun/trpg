package com.trpg.mapper;

import com.trpg.domain.model.character.character.Detail;
import com.trpg.domain.model.character.character.DetailList;
import com.trpg.entity.CharacterInfo;
import com.trpg.entity.CharacterInfoEntity;
import com.trpg.entity.DetailEntity;

import java.util.List;

/**
 * Detailテーブルのマッピングクラス
 */

public  class DetailMapper {
    public static DetailList toDomain(List<DetailEntity> detailEntityList) {
        return null;
    }

    public static DetailEntity toEntity(int characterId, Detail detail){
        DetailEntity detailEntity = new DetailEntity(detail.getId(),characterId , detail.getType().getId(), detail.getDetail());
        return detailEntity;
    }
}
