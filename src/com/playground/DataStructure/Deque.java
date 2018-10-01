package com.playground.DataStructure;

/**
 * Double-end queue
 * @author zhongya
 */

public interface Deque
{
    int peekFirst();
    int peekLast();
    int pollFirst();
    int pollLast();
    void offerFirst(int k);
    void offerLast(int k);
    int size();
    default boolean isEmpty()
    {
        return size() == 0;
    }
}
