package com.ads;

import java.io.*;
import java.util.*;

import static com.ads.MinHeap2.stringToParams;

public class Main {
    static int counter = 0;
    private Node[] nodes;

    /*public Main(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }*/

    public static void main(String[] args) throws IOException {
        // write your code here
        Main main = new Main();
        MinHeap2 minHeap = new MinHeap2(15); //Initializing empty array for minHeap
        RedBlackTree2 rbt = new RedBlackTree2(); //
        /*File file = new File("C:\\Me_Florida\\UF_courses\\ADS\\ADSProject\\ADS_ProgramminProject\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while((st=br.readLine())!=null){
            System.out.println(st);
        }*/
        /*FileReader fr =
                new FileReader("C:\\Me_Florida\\UF_courses\\ADS\\ADSProject\\ADS_ProgramminProject\\input.txt");

        int i;
        while ((i=fr.read()) != -1)
            System.out.print((char) i);*/
        File file =
                new File("C:\\Me_Florida\\UF_courses\\ADS\\ADSProject\\ADS_ProgramminProject\\input.txt");
        Scanner sc = new Scanner(file);

       /* while (sc.hasNextLine()) {
            String currentSt=sc.nextLine();
            System.out.println(currentSt);
            int commandTime =Integer.parseInt(currentSt.split(":")[0]);
            int nextCommandTime =commandTime+1;
            if(sc.hasNextLine()) {
                String nextSt = sc.nextLine();
                nextCommandTime = Integer.parseInt(nextSt.split(":")[0]);
            }
            while(counter>=commandTime && counter<nextCommandTime) {
                System.out.println("counter : " + counter);
                if (currentSt.contains("Insert") && commandTime==counter) {*/
                    /*int[] params = stringToParams("2,3,4");
                    Node node1 = new Node(params[0], params[1], params[2]);
                    minHeap.insert(node1);
                    RedBlackTree2.RBTNode rbtNode1 = new RedBlackTree2.RBTNode(node1);
                    rbt.insertRBT(rbtNode1);
                    node1.setRBTNode(rbtNode1);*/
                    //minHeap.printHeap();
                    //rbt.printLevelOrder();


                    //minHeap.process(minHeap, rbt);
                /*} else {
                    minHeap.process(minHeap,rbt);
                }
                counter++;
            }
            //System.out.println(st);
            //st=nextSt;

        }*/
        //while (counter > 0){
        //int commandTime = ;
        /*while ((st) != null) {
            int commandTime =Integer.parseInt(st.split(":")[0]);
            String nextSt=br.readLine();
            int nextCommandTime =commandTime+1;
            if(nextSt!=null){
                nextCommandTime = Integer.parseInt(nextSt.split(":")[0]);
            }
            while(counter>=commandTime && counter<nextCommandTime) {
                System.out.println("counter : " + counter);
                if (st.contains("Insert") && commandTime==counter) {
                    int[] params = stringToParams(st);
                    Node node1 = new Node(params[0], params[1], params[2]);
                    minHeap.insert(node1);
                    RedBlackTree2.RBTNode rbtNode1 = new RedBlackTree2.RBTNode(node1);
                    rbt.insertRBT(rbtNode1);
                    node1.setRBTNode(rbtNode1);
                    minHeap.printHeap();
                    rbt.printLevelOrder();
                    minHeap.process(minHeap, rbt);
                } else {
                    minHeap.process(minHeap,rbt);
                }
                counter++;
            }
            //System.out.println(st);
            st=nextSt;
        }*/

    //}
        /*File file = new File("C:\\Me_Florida\\UF_courses\\ADS\\ADSProject\\ADS_ProgramminProject\\input.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\n");
        System.out.println(sc.next());*/


        /** Hard coded insert samples and delete
         * */
                int[] params = stringToParams("1,10,5");
        Node node1 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node1);
        RedBlackTree2.RBTNode rbtNode1 = new RedBlackTree2.RBTNode(node1);

        rbt.insertRBT(rbtNode1);
        node1.setRBTNode(rbtNode1);
//        System.out.print("After inserting 1,10,5");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("4,6,10");
        Node node2 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node2);
        RedBlackTree2.RBTNode rbtNode2 = new RedBlackTree2.RBTNode(node2);
        rbt.insertRBT(rbtNode2);
        node2.setRBTNode(rbtNode2);
//        System.out.print("After inserting 4,6,10");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("9,6,15");
        Node node3 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node3);
        RedBlackTree2.RBTNode rbtNode3 = new RedBlackTree2.RBTNode(node3);
        rbt.insertRBT(rbtNode3);
        node3.setRBTNode(rbtNode3);
//        System.out.print("After inserting 9,6,15");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("6,10,4");
        Node node4 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node4);
        RedBlackTree2.RBTNode rbtNode4 = new RedBlackTree2.RBTNode(node4);
        rbt.insertRBT(rbtNode4);
        node4.setRBTNode(rbtNode4);
//        System.out.print("After inserting 6,10,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("5,5,4");
        Node node5 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node5);
        RedBlackTree2.RBTNode rbtNode5 = new RedBlackTree2.RBTNode(node5);
        rbt.insertRBT(rbtNode5);
        node5.setRBTNode(rbtNode5);
//        System.out.print("After inserting 5,5,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("28,1,4");
        Node node6 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node6);
        RedBlackTree2.RBTNode rbtNode6 = new RedBlackTree2.RBTNode(node6);
        rbt.insertRBT(rbtNode6);
        node6.setRBTNode(rbtNode6);
//        System.out.print("After inserting 28,1,5");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("13,17,4");
        Node node7 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node7);
        RedBlackTree2.RBTNode rbtNode7 = new RedBlackTree2.RBTNode(node7);
        rbt.insertRBT(rbtNode7);
        node7.setRBTNode(rbtNode7);
//        System.out.print("After inserting 13,17,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("7,3,4");
        Node node8 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node8);
        RedBlackTree2.RBTNode rbtNode8 = new RedBlackTree2.RBTNode(node8);
        rbt.insertRBT(rbtNode8);
        node8.setRBTNode(rbtNode8);
//        System.out.print("After inserting 7,3,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("17,11,4");
        Node node9 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node9);
        RedBlackTree2.RBTNode rbtNode9 = new RedBlackTree2.RBTNode(node9);
        rbt.insertRBT(rbtNode9);
        node9.setRBTNode(rbtNode9);
//        System.out.print("After inserting 17,11,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("15,9,4");
        Node node10 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node10);
        RedBlackTree2.RBTNode rbtNode10 = new RedBlackTree2.RBTNode(node10);
        rbt.insertRBT(rbtNode10);
        node10.setRBTNode(rbtNode10);
//        System.out.print("After inserting 15,9,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("3,9,4");
        Node node11 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node11);
        RedBlackTree2.RBTNode rbtNode11 = new RedBlackTree2.RBTNode(node11);
        rbt.insertRBT(rbtNode11);
        node11.setRBTNode(rbtNode11);
//        System.out.print("After inserting 3,9,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("8,10,4");
        Node node12 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node12);
        RedBlackTree2.RBTNode rbtNode12 = new RedBlackTree2.RBTNode(node12);
        rbt.insertRBT(rbtNode12);
        node12.setRBTNode(rbtNode12);
//        System.out.print("After inserting 8,10,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("11,10,4");
        Node node13 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node13);
        RedBlackTree2.RBTNode rbtNode13 = new RedBlackTree2.RBTNode(node13);
        rbt.insertRBT(rbtNode13);
        node13.setRBTNode(rbtNode13);
//        System.out.print("After inserting 11,10,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
        params = stringToParams("2,23,4");
        Node node14 = new Node(params[0],params[1],params[2]);
        minHeap.insert(node14);
        RedBlackTree2.RBTNode rbtNode14 = new RedBlackTree2.RBTNode(node14);
        rbt.insertRBT(rbtNode14);
        node14.setRBTNode(rbtNode14);
//        System.out.print("After inserting 2,23,4");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
//        rbt.printLevelOrder();
        //
//        minHeap.process(minHeap,rbt);
//        System.out.println("After deleting");
//        System.out.print("Heap is : ");
//        minHeap.printHeap();
//        System.out.print("RBT is : ");
        //rbt.printLevelOrder();
        RedBlackTree2.RBTNode printBuildingNode = rbt.printBuilding(10);
        if(printBuildingNode==null)
            System.out.println("(" + 0 + "," + 0 + "," + 0 + ")");
        else
            System.out.println("("+printBuildingNode.key.getBuildingNum()+","+printBuildingNode.key.getExecutionTime()+","+printBuildingNode.key.getTotalTime()+")");
        List<RedBlackTree2.RBTNode> rangeBuildings = rbt.printBuilding(5,10);
        if(rangeBuildings.size()==0){
            System.out.println("(" + 0 + "," + 0 + "," + 0 + ")");
        } else {
            int i=0;
            for(RedBlackTree2.RBTNode rbtNode: rangeBuildings){
                System.out.print("(" + rbtNode.key.getBuildingNum() + "," + rbtNode.key.getExecutionTime() + "," + rbtNode.key.getTotalTime() + ")");
                i++;
                if(i!=rangeBuildings.size())  System.out.print(",");
            }
        }


    }

}
