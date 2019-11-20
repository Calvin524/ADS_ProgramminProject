package com.ads;

public class HeapNode {
    int buildingNum;
    int executionTime;
    int totalTime;
    int tempProgress;
    RedBlackTree2.RBTNode rbtNode;

    /* Constructor */
    public HeapNode(int buildingNumber, int execTime, int totTime)
    {
        buildingNum = buildingNumber;
        executionTime = execTime;
        totalTime = totTime;
    }

    public HeapNode(int buildingNumber, int execTime, int totTime, int tempProg, RedBlackTree2.RBTNode rbt) {
        buildingNum = buildingNumber;
        executionTime = execTime;
        totalTime = totTime;
        tempProgress = tempProg;
        rbtNode = rbt;
    }

    //Getter
    public int getBuildingNum() {
        return buildingNum;
    }

    // Setter
    public void setBuildingNum(int newBuildingNum) {
        this.buildingNum = newBuildingNum;
    }

    //Getter
    public int getExecutionTime() {
        return executionTime;
    }

    // Setter
    public void setExecutionTime(int newExecTime) {
        this.executionTime = newExecTime;
    }

    //Getter
    public int getTotalTime() {
        return totalTime;
    }

    // Setter
    public void setTotalTime(int newTotalTime) {
        this.totalTime = newTotalTime;
    }

    //Getter
    public int getTempProgress() {
        return tempProgress;
    }

    // Setter
    public void setTempProgress(int newTempProgress) {
        this.tempProgress = newTempProgress;
    }

    //Getter
    public RedBlackTree2.RBTNode getRBTNode() {
        return rbtNode;
    }

    // Setter
    public void setRBTNode(RedBlackTree2.RBTNode newRBTNode) {
        this.rbtNode = newRBTNode;
    }

}
