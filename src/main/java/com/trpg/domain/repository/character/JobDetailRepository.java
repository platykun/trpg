package com.trpg.domain.repository.character;

import com.trpg.entity.JobDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 職業詳細リポジトリ。
 */
@Repository
public interface JobDetailRepository extends JpaRepository<JobDetailEntity, Integer> {
    /**
     * 職業詳細を取得する。
     *
     * @param id 職業詳細ID
     * @return 職業詳細リスト
     */
    List<JobDetailEntity> findById(int id);

    /**
     * JOB_IDをもとに職業詳細を取得する。
     *
     * @param jobId 職業ID
     * @return 職業詳細リスト
     */
    List<JobDetailEntity> findByJobId(int jobId);
}
