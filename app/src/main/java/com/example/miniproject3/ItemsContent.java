package com.example.miniproject3;

public class ItemsContent {

    String projectName;
    String remainderTime;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRemainderTime() {
        return remainderTime;
    }

    public void setRemainderTime(String remainderTime) {
        this.remainderTime = remainderTime;
    }

    public ItemsContent(String projectName, String remainderTime) {
        this.projectName = projectName;
        this.remainderTime = remainderTime;
    }
}
