package com.trpg.domain.model.character.character;

import lombok.Getter;

import java.util.ArrayList;

/**
 * 職業リスト。
 */
public class JobList {
    /** 職業リスト */
    @Getter
    private ArrayList<Job> jobList;

    public JobList(){
        jobList = new ArrayList<>();
    }

    /** 職業リストに職業を追加する。 */
    public void add(Job job){
        jobList.add(job);
    }
}
