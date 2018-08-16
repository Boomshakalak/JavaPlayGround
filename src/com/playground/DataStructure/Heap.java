package com.playground.DataStructure;

public interface Heap
{
    int peek();
    int poll();
    void offer(int k);
    int size();
    boolean isFull();
    default boolean isEmpty()
    {
        return size() == 0;
    }
}
