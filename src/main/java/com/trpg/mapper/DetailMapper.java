package com.trpg.mapper;

import com.trpg.domain.model.character.character.Detail;
import com.trpg.domain.model.character.character.DetailList;
import com.trpg.domain.model.character.character.DetailType;
import com.trpg.entity.DetailEntity;

import java.util.List;

/**
 * Detailテーブルのマッピングクラス
 */
public  class DetailMapper {
    /**
     * DetailテーブルからDomainドメインオブジェクトを作成する。
     *
     * @param detailEntity Detailエンティティ
     * @return Detailドメインオブジェクト
     */
    public static Detail toDomain(DetailEntity detailEntity) {

        int id = detailEntity.getId();
        DetailType type = DetailType.getType(detailEntity.getDetailType());
        String detail = detailEntity.getDetail();

        Detail detailDomain = new Detail(id, type, detail);
        return detailDomain;
    }

    /**
     * DetailドメインオブジェクトからDetailテーブルを作成する。
     *
     * @param characterId キャラクタID
     * @param detail Detailドメインオブジェクト
     * @return Detailテーブル
     */
    public static DetailEntity toEntity(int characterId, Detail detail){
        DetailEntity detailEntity = new DetailEntity(detail.getId(),characterId , detail.getType().getId(), detail.getDetail());
        return detailEntity;
    }
}
