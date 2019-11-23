package com;

import java.io.*;
import java.util.*;

import static com.MinHeap.stringToParams;

public class RisingCity {
    static int days = 0;
    static int maxBuildings = 2000;

    public static void main(String[] args) throws IOException {
        // write your code here
        long start1 = System.currentTimeMillis();
        MinHeap minHeap = new MinHeap(maxBuildings); /**Initializing array for minHeap*/
        RedBlackTree rbt = new RedBlackTree();

        File file = new File("C:\\Me_Florida\\UF_courses\\ADS\\ADSProject\\ADS_ProgramminProject\\input_2.txt");
        StringBuilder str = new StringBuilder();
        BufferedWriter writer = new BufferedWriter(new FileWriter("output_wip", false));
        writer.flush();
        List<Building> buildingList = new ArrayList<>();
        List<String> commandList = new ArrayList<>();


        Scanner sc = new Scanner(file);
        int completedBuildingNum = -1;
        String line;
        /** Storing all the commands in a list called commandList*/
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if(!line.trim().equals(""))
                commandList.add(line);
        }

        /**read each command from commandList*/
        for(int i=0;i<commandList.size();i++) {
            String currentLine = commandList.get(i);
            int commandTime =Integer.parseInt(currentLine.split(":")[0]);
            String currentCommand=currentLine.split(":")[1];
            int nextCommandTime =Integer.MAX_VALUE;
            String nextCommand=null;
            if(i!=commandList.size()-1) {
                nextCommand = commandList.get(i+1);//scCopy.nextLine();
                if(!nextCommand.equalsIgnoreCase("")) nextCommandTime = Integer.parseInt(nextCommand.split(":")[0]);
            }
            while(days>=commandTime && days<nextCommandTime) {
                if (currentCommand.contains("Insert") && commandTime==days) {
                    /** If the command is Insert and the time of the command matches the current day*/
                    int[] params = stringToParams(currentCommand);
                    if(rbt.printBuilding(params[0])==null) {
                        BuildingProperties buildingProperties = new BuildingProperties(params[0], params[1], params[2]);
                        Building building = new Building(buildingProperties);
                        RedBlackTree.RBTProperties rbtProperties = new RedBlackTree.RBTProperties(new BuildingProperties(buildingProperties.buildingNum, buildingProperties.executionTime, buildingProperties.totalTime));
                        rbt.insertRBT(rbtProperties);
                        building.setRBTProperties(rbtProperties);
                        buildingList.add(building);
                        /** If there is no building currently under construction, insert into the heap and remove from the list of building in the queue*/
                        if(minHeap.heapSize==0 || minHeap.heap[0].getProgress()==0) {
                            minHeap.insert(buildingList.get(0));
                            buildingList.remove(0);
                        }
                    } else {
                        str.append("Building with buildingNum ").append(params[0]).append(" exists\n");
                    }
                } else if(currentCommand.contains("PrintBuilding") && commandTime==days){
                    /** If the command is PrintBuilding and the time of the command matches the current day*/
                    if(currentCommand.contains(",")){
                        /** If the command is PrintBuilding between two building numbers*/
                        int[] buildingNums = stringToParams(currentCommand);
                        List<RedBlackTree.RBTProperties> rangeBuildings = rbt.printBuilding(buildingNums[0],buildingNums[2]);
                        for(Building building : buildingList){
                            if(building.getBuildingProperties().getBuildingNum()>buildingNums[0] && building.getBuildingProperties().getBuildingNum()<buildingNums[2]) {
                                rangeBuildings.add(building.getRBTProperties());
                            }
                        }
                        if(rangeBuildings.size()==0){
                            str.append("(" + 0 + "," + 0 + "," + 0 + ")");
                        } else {
                            int j=0;
                            for(RedBlackTree.RBTProperties rbtBuilding: rangeBuildings){
                                str.append("(").append(rbtBuilding.buildingProperties.getBuildingNum()).append(",").append(rbtBuilding.buildingProperties.getExecutionTime()).append(",").append(rbtBuilding.buildingProperties.getTotalTime()).append(")");
                                j++;
                                if(j!=rangeBuildings.size())  str.append(",");
                                /*if(rbtBuilding.key.getExecutionTime()==rbtBuilding.key.getTotalTime()){
                                    rbt.delete(rbtBuilding);
                                }*/
                            }
                        }
                        str.append("\n");
                    } else {
                        /** If the command is to PrintBuilding with a particular building number*/
                        String part = currentCommand.split("\\(")[1];
                        int buildingNum = Integer.parseInt(part.split("\\)")[0]);
                        RedBlackTree.RBTProperties printBuilding = rbt.printBuilding(buildingNum);
                        /*for(Building building : buildingList){
                            if(building.getBuildingProperties().getBuildingNum()==buildingNum)
                                printBuilding=building.getRBTProperties();
                        }*/
                        if (printBuilding == null) {
                            str.append("(" + 0 + "," + 0 + "," + 0 + ")\n");
                        } else {
                            str.append("(").append(printBuilding.buildingProperties.getBuildingNum()).append(",").append(printBuilding.buildingProperties.getExecutionTime()).append(",").append(printBuilding.buildingProperties.getTotalTime()).append(")\n");
                            /*if(printBuilding.key.getExecutionTime()==printBuilding.key.getTotalTime()){
                                rbt.delete(printBuilding);
                            }*/
                        }
                    }
                    /*if(completedBuildingNum!=-1) {
                        RedBlackTree.RBTProperties completedBuilding = rbt.printBuilding(completedBuildingNum);
                        if (completedBuilding!=null && (completedBuilding.key.getExecutionTime() == completedBuilding.key.getTotalTime())) {
                            rbt.delete(completedBuilding);
                        }
                    }*/
                }
                days++;
                /** If completedBuildingNum is not -1, it means a building construction is completed */
                if((completedBuildingNum = minHeap.construct(nextCommand, buildingList, minHeap.heap[0], rbt))!=-1)
                    str.append("(").append(completedBuildingNum).append(",").append(days).append(")\n");

                /** If there is no more command left*/
                if(nextCommand==null){//if(i==commandList.size()-1){
                    //while(rbt.size()!=0){
                        //rbt.deleteCompleted();
                    //}
                   /* while(rbt.findProperties(z, rbt.root)!=null){
                        if(minHeap.heap[k].getBuildingProperties().getExecutionTime()==minHeap.heap[k].getBuildingProperties().getTotalTime())
                            rbt.delete(minHeap.heap[k].getRBTProperties());
                            //minHeap.delete(k);
                    }*/
                    /*if(!minHeap.isEmpty() && minHeap.heap[0].getBuildingProperties().getExecutionTime()==minHeap.heap[0].getBuildingProperties().getTotalTime()) {
                        rbt.delete(minHeap.heap[0].getRBTProperties());
                        minHeap.delete(0);
                    }*/
                    /**If the heap is empty and there are no more commands left then stop*/
                    if(minHeap.isEmpty())
                        break;
                }
            }
        }
        /**write to the output file*/
        writer.append(str);
        writer.close();

        //Remove the below part
        long end1 = System.currentTimeMillis();
        System.out.println("Application on the whole takes " + (end1 - start1) + "ms");
        System.gc();
        Runtime rt = Runtime.getRuntime();
        long usedMB = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        System.out.println( "memory usage " + usedMB+"MB");
    }

}
