package com.playground.DataStructure;

public interface Stack
{
    int size();
    int peek();
    int pop();
    void push(int k);
    default boolean isEmpty()
    {
        return size() == 0;
    }
}
