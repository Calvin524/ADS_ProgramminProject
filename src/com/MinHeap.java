package com;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * MinHeap implemented using Array
 */
public class MinHeap {

    private static final int degree= 2;
    public Building[] heap;
    private RedBlackTree.RBTProperties rbtProperties;
    public int heapSize;
    public BuildingProperties nullBuilding=new BuildingProperties(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);

    /**
     * This will initialize our heap with default size.
     * @param capacity
     */
    public MinHeap(int capacity){
        heapSize = 0;
        heap = new Building[capacity+1];
        Arrays.fill(heap, new Building(nullBuilding));

    }

    /**
     * This will check if the heap is empty or not
     * Complexity: O(1)
     * @return
     */
    public boolean isEmpty(){
        return heapSize==0;
    }

    /**
     * This will check if the heap is full or not
     * Complexity: O(1)
     * @return
     */
    public boolean isFull(){
        return heapSize == heap.length;
    }


    private int parent(int i){
        return (i-1)/degree;
    }

    private int childIndex(int i,int j){
        return degree*i  +j;
    }

    /**
     * This will insert new building in to heap
     * @param buidling
     */
    public void insert(Building buidling){
        if(isFull())
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        heap[heapSize++] = buidling;
        heapifyNewBuilding(heapSize-1);
    }

    /**
     * This will delete element at index
     * @param index
     * @return
     */
    public int delete(int index){
        if(isEmpty())
            throw new NoSuchElementException("No element present in heap");
        int buildingNum = heap[index].getBuildingProperties().getBuildingNum();

        heap[index].setBuildingProperties(heap[heapSize -1].getBuildingProperties());
        heap[index].setProgress(heap[heapSize -1].getProgress());
        heap[index].setRBTProperties(heap[heapSize -1].getRBTProperties());
        heapSize--;
        heapifyCompletedBuilding(index);
        int lastIndex = heapSize;
        heap[lastIndex].setBuildingProperties(nullBuilding);
        heap[lastIndex].setProgress(0);
        heap[lastIndex].setRBTProperties(null);
        return buildingNum;
    }

    /**
     * This method used to maintain the heap property while inserting an element.
     * @param i
     */
    public void heapifyNewBuilding(int i) {
        Building temp = heap[i];
        while(i>0 && ((temp.getBuildingProperties().getExecutionTime() < heap[parent(i)].getBuildingProperties().getExecutionTime())
                    || (temp.getBuildingProperties().getExecutionTime()==heap[parent(i)].getBuildingProperties().getExecutionTime()
                        && temp.getBuildingProperties().getBuildingNum()<heap[parent(i)].getBuildingProperties().getBuildingNum()))){
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }

    /**
     * This method used to maintain the heap property while deleting an element.
     * @param i
     */
    public void heapifyCompletedBuilding(int i){
        int child;
        Building temp = new Building(heap[i].getBuildingProperties(),heap[i].getProgress(),heap[i].getRBTProperties());
        while(childIndex(i, 1) < heapSize){
            child = minChild(i);// Finding out the min of the children
            if(temp.getBuildingProperties().getExecutionTime() > heap[child].getBuildingProperties().getExecutionTime()
            || temp.getBuildingProperties().getExecutionTime()==heap[child].getBuildingProperties().getExecutionTime() && temp.getBuildingProperties().getBuildingNum()>heap[child].getBuildingProperties().getBuildingNum()){ // Comparing parent with the min of the children
                /** If execution time of the parent is more than that of min of the children
                 * Or If execution time of the parent is equal to that of min of the children, and building number of parent is equal more than that of min of the children
                 * place the minChild as parent and below place the parent in minChild's place*/
                heap[i].setBuildingProperties(heap[child].getBuildingProperties());
                heap[i].setProgress(heap[child].getProgress());
                heap[i].setRBTProperties(heap[child].getRBTProperties());
            } else
                break;

            i = child;
        }
        heap[i].setBuildingProperties(temp.getBuildingProperties());
        heap[i].setProgress(temp.getProgress());
        heap[i].setRBTProperties(temp.getRBTProperties());
    }

    /**
     * Get the min of the children
     * @param i
     * @return
     */
    private int minChild(int i) {
        int leftChild = childIndex(i, 1);
        int rightChild = childIndex(i, 2);
        int minChild=leftChild;
        if(heap[leftChild].getBuildingProperties().getExecutionTime()>heap[rightChild].getBuildingProperties().getExecutionTime()){
            minChild=rightChild;
        } else if(heap[leftChild].getBuildingProperties().getExecutionTime()==heap[rightChild].getBuildingProperties().getExecutionTime()){
            if(heap[leftChild].getBuildingProperties().getBuildingNum()>heap[rightChild].getBuildingProperties().getBuildingNum()){
                minChild=rightChild;
            }
        }
        return minChild;
    }
}