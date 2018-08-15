package com.playground.DataStructure;

public interface Queue
{
    void enqueue(int k);
    int dequeue();
    int peek();
    int size();
    default boolean isEmpty()
    {
        return size() == 0;
    }
}
