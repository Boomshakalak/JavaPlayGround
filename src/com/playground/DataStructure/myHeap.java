package com.playground.DataStructure;

import com.util.print;

import java.util.NoSuchElementException;

/**
 * Implement a heap using a int array
 * @author zhongya
 */

public class myHeap implements Heap
{
    public static final int DEFAULT_CAPACITY = 256;
    int[] array;
    int size;
    public myHeap(int cap)
    {
        if (cap <= 0) throw new IllegalArgumentException("myHeap cannot be constructed with capacity of 0 or below");
        array = new int[cap];
        size = 0;
    }

    public myHeap()
    {
        array = new int[DEFAULT_CAPACITY];
    }

    public myHeap(int[] array)
    {
        if (array == null || array.length < 1) throw new IllegalArgumentException("myHeap(int[] array) : " +
                "Cannot initiate a heap using a null array or empty array");
        this.array = new int[array.length];
        System.arraycopy(array,0, this.array, 0, array.length);
        size = array.length;
        heapify();
    }

    private void percolateUp(int index)
    {
        int cur = index;
        while (cur > 0)
        {
            int parent = (cur - 1)/2;
            if (array[parent] > array[cur])
            {
                swap(array, parent, cur);
            }
            else break;
            cur = parent;
        }
    }

    private void percolateDown(int index)
    {
        int cur = index;
        while (cur <= (size -2) / 2)
        {
            int child1 = 2 * cur + 1;
            int child2 = 2 * cur + 2;
            int candidate = child1;
            if (child2 <= size - 1 && array[child2] < array[child1])
            {
                candidate = child2;
            }
            if (array[candidate] < array[cur])
            {
                swap(array, cur, candidate);
                cur = candidate;
            }
            else break;
        }
    }

    private void heapify()
    {
        for (int i = size /2 -1; i >=0; i--)
        {
            percolateDown(i);
        }
    }

    @Override
    public int peek()
    {
        if (isEmpty()) throw new NoSuchElementException("myHeap::peek : cannot get element from an empty heap");
        return array[0];
    }

    @Override
    public int poll()
    {
        if (isEmpty()) throw new NoSuchElementException("myHeap::peek : cannot get element from an empty heap");
        int res = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    @Override
    public void offer(int k)
    {
        if (isFull())
        {
            int[] newArr = new int[array.length * 2];
            System.arraycopy(array, 0 , newArr, 0, array.length);
            array = newArr;
        }
        array[size++] = k;
        percolateUp(size - 1);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isFull()
    {
        return size() == array.length;
    }

    private void swap(int[] arr, int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void printHeapArray()
    {
        print.printArray(array);
    }
}
