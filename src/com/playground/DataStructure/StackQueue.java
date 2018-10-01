package com.playground.DataStructure;

import java.util.NoSuchElementException;

/**
 * Implement a queue using two stacks
 * @author zhongya
 */

public class StackQueue implements Queue
{
    Stack st1;
    Stack st2;
    public StackQueue()
    {
        st1 = new LinkedList();
        st2 = new LinkedList();
    }
    @Override
    public void enqueue(int k)
    {
        st1.push(k);
    }

    @Override
    public int dequeue()
    {
        if (isEmpty()) throw new NoSuchElementException("StackQueue::dequeue : The container is empty");
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        return st2.pop();
    }

    @Override
    public int peek()
    {
        while(!st1.isEmpty())
        {
            st2.push(st1.pop());
        }
        return st2.peek();
    }

    @Override
    public int size()
    {
        return st1.size() + st2.size();
    }
}
