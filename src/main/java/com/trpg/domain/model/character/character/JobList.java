package com.trpg.domain.model.character.character;

import java.util.ArrayList;

public class JobList {
    private ArrayList<Job> jobList;

    public JobList(){
        jobList = new ArrayList<Job>();
    }
    
    public void add(Job job){
        jobList.add(job);
    }
}
