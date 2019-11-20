package com.ads;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static com.ads.Main2.triple;

public class MinHeap2 {

    //RedBlackTree2.RBTNode rbt = new RedBlackTree2.RBTNode();

    /**
     * MinHeap implemented using Array
     */


        private static final int d= 2;
        private Node[] heap;
        private RedBlackTree2.RBTNode node;
        private int heapSize;


        /**
         * This will initialize our heap with default size.
         */
        public MinHeap2(int capacity){
            heapSize = 0;
            heap = new Node[capacity+1];//int[capacity+1][2];
            //heap.setBuildingNum(-1);
          //node = new RedBlackTree2.Node();//int[capacity+1][2];
            Arrays.fill(heap, new Node(-1,-1,-1));//new int[]{-1,-1});//

        }

        /**
         *  This will check if the heap is empty or not
         *  Complexity: O(1)
         */
        public boolean isEmpty(){
            return heapSize==0;
        }

        /**
         *  This will check if the heap is full or not
         *  Complexity: O(1)
         */
        public boolean isFull(){
            return heapSize == heap.length;
        }


        private int parent(int i){
            return (i-1)/d;
        }

        private int kthChild(int i,int k){
            return d*i  +k;
        }

        /**
         *  This will insert new element in to heap
         *  Complexity: O(log N)
         *  As worst case scenario, we need to traverse till the root
         */
        public void insert(int[] x){
            Node heapx= new Node(x[0],x[1],x[2]);
            if(isFull())
                throw new NoSuchElementException("Heap is full, No space to insert new element");
            heap[heapSize++] = heapx;
            heapifyUp(heapSize-1);
        }

        /**
         *  This will delete element at index x
         *  Complexity: O(log N)
         *
         */
        public int delete(int x){
            if(isEmpty())
                throw new NoSuchElementException("Heap is empty, No element to delete");
            int key = heap[x].getBuildingNum();
            heap[x] = heap[heapSize -1];
            heapSize--;
            heapifyDown(x);
            return key;
        }

        /**
         *  This method used to maintain the heap property while inserting an element.
         *
         */
        private void heapifyUp(int i) {
            Node temp = heap[i];
            //int parenti = parent(i);
            while(i>0 && ((temp.getExecutionTime() < heap[parent(i)].getExecutionTime())
                    || (temp.getExecutionTime()==heap[parent(i)].getExecutionTime() && temp.getBuildingNum()<heap[parent(i)].getBuildingNum()))){

                //if((temp[1]==heap[parenti][1] && temp[0]<heap[parenti][0]) || temp[1]<heap[parenti][1]) {//If execution times are same for two nodes
                    heap[i] = heap[parent(i)];

                //}
                i = parent(i);
            }
            heap[i] = temp;
        }

        /**
         *  This method used to maintain the heap property while deleting an element.
         *
         */
        private void heapifyDown(int i){
            int child;
            Node temp = heap[i];
            while(kthChild(i, 1) < heapSize){
                child = minChild(i);// Finding out the min of the children
                if(temp.getExecutionTime() > heap[child].getExecutionTime()){ // Comparing parent with the min of the children
                    heap[i] = heap[child]; // If parent is more than min of the children, place the minChild as parent and below place the parent in minChild's place
                }else if(temp.getExecutionTime()==heap[child].getExecutionTime() && temp.getBuildingNum()>heap[child].getBuildingNum()){
                    heap[i] = heap[child];
                } else
                    break;

                i = child;
            }
            heap[i] = temp;
        }

        private int minChild(int i) {
            int leftChild = kthChild(i, 1);
            int rightChild = kthChild(i, 2);
            int minChild=rightChild;
            if(heap[leftChild].getExecutionTime()<heap[rightChild].getExecutionTime()){
                minChild=leftChild;
            } else if(heap[leftChild].getExecutionTime()==heap[rightChild].getExecutionTime()){
                if(heap[leftChild].getBuildingNum()<heap[rightChild].getBuildingNum()){
                    minChild=leftChild;
                }
            }
            return minChild;
        }

        /**
         *  This method used to print all element of the heap
         *
         */
        public void printHeap()
        {
            System.out.print("\nHeap = ");
            for (int i = 0; i < heapSize; i++)
                System.out.print("("+heap[i].getBuildingNum()+","+heap[i].getExecutionTime() +","+heap[i].getTotalTime()+") ");
            System.out.println();
        }
        /**
         *  This method returns the min element of the heap.
         *  complexity: O(1)
         */
        /*public int[] findMin(){
            if(isEmpty())
                throw new NoSuchElementException("Heap is empty.");
            return heap[0];
        }*/

    public static int[] stringToParams(String input) {
        input = input.trim();
        //input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }


        String[] params = input.split(",");
        int[] output = new int[3];
      /*  String part = params[0].split("\\(")[1];
        output[0] = Integer.parseInt(part);
        output[1]=0;
        part = params[1].split("\\)")[0];
        output[2] = Integer.parseInt(part);*/
        String part = params[0].trim();
        output[0] = Integer.parseInt(part);
        part = params[1].trim();
        output[1]=Integer.parseInt(part);
        part = params[2].trim();
        output[2] = Integer.parseInt(part);
        /*for(int index = 0; index < params.length; index++) {
            if(index==1){
                output[index]=0;
            }else {
                String part = params[index].trim();
                output[index] = Integer.parseInt(part);
            }
        }*/
        return output;
    }
    // Function to print the contents of the heap
    public void process()
    {
        //System.out.println(Heap[1][0]+" "+Heap[1][1]);
        heap[0].setExecutionTime(3);//Math.min(heap[0].getTotalTime(), 5));
        //heap[0].setBuildingNum(6);
        if(heap[0].getExecutionTime()==heap[0].getTotalTime()){
            delete(0);
        } else {
            heapifyDown(0);
        }
    }

        public static void main(String[] args){
            MinHeap2 minHeap = new MinHeap2(10);

            int[] params = stringToParams("1,0,5");
            minHeap.insert(params);
            minHeap.printHeap();
            params = stringToParams("5,0,10");
            minHeap.insert(params);
            minHeap.printHeap();
            params = stringToParams("9,0,15");
            minHeap.insert(params);
            minHeap.printHeap();
            params = stringToParams("10,0,3");
            minHeap.insert(params);
            minHeap.printHeap();
            params = stringToParams("6,0,4");
            //RedBlackTree2.Node node = new RedBlackTree2.Node(params);
            //insertRBT(params);
            minHeap.insert(params);
            minHeap.printHeap();
            params = stringToParams("4,0,4");
            minHeap.insert(params);
            minHeap.printHeap();
            params = stringToParams("7,0,4");
            minHeap.insert(params);
            minHeap.printHeap();
            minHeap.process();
            //minHeap.delete(0);
            minHeap.printHeap();
        }

}