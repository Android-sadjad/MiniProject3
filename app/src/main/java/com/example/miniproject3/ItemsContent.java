package com.example.miniproject3;

public class ItemsContent {



    String projectName;
    String remainderTime;
    int progress;



    public ItemsContent(String projectName, String remainderTime, int progress) {
        this.projectName = projectName;
        this.remainderTime = remainderTime;
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getRemainderTime() {
        return remainderTime;
    }




}
