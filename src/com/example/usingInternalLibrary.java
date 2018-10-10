package com.example;

import com.playground.Algorithm.BinarySearch;
import com.playground.Algorithm.Sort;
import com.playground.DataStructure.*;
import com.playground.TestGenerator.IntegerGenerator;
import com.playground.TestGenerator.TreeGenerator;
import com.util.print;



public class usingInternalLibrary {

    public static void selectionSortArray()
    {
        int[] test = IntegerGenerator.generateArray(15);
        Sort.selectionSort(test);
        print.printArray(test);
    }

    public static void mergeSortArray()
    {
        int[] test = IntegerGenerator.generateArray(15);
        Sort.mergeSort(test);
        print.printArray(test);
    }

    public static void quickSortArray()
    {
        int[] test = IntegerGenerator.generateArray(15);
        Sort.quickSort(test);
        print.printArray(test);
    }

    public static void testLinkedList()
    {
        LinkedList l = new LinkedList();
        System.out.println(l);
        ListNode node = new ListNode(10);
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        System.out.println(l.size());
        System.out.println(l);
        l.addFromHead(node);
        System.out.println(l);
        l.add(node);
        System.out.println(l);
    }

    public static void testHashMap()
    {
        HashMap<Integer, Integer> map = new HashMap<>(5);
        System.out.println( "Initial Capacity:" + map.capacity());
        for (int i = 0 ; i < 10 ; i++)
        {
            map.put(i,i);
        }
        map.remove(0);
        System.out.println(map);
        System.out.println("Capacity:" + map.capacity());
        System.out.println("Size:" + map.size());
    }

    public static void testTree()
    {
        TreeNode root = TreeGenerator.generateBSTFromArray(IntegerGenerator.DEFAULT_GENERATOR.getArray(15));
        System.out.println(Tree.preorderTraversal(root));
        System.out.println(Tree.inorderTraversal(root)); // This should have a sorted result
        System.out.println(Tree.postOrderTraversal(root));
    }

    public static void testBinarySearch()
    {
        int[] arr = IntegerGenerator.generateArray(20);
        Sort.quickSort(arr);
        print.printArray(arr);
        int[] myArr = {1,3,4,7,7,7,7,9,12,16};
        System.out.println("find first 7:" + BinarySearch.findFirst(myArr, 7));
        System.out.println("find last 7 :" + BinarySearch.findLast(myArr, 7));
        for (int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(BinarySearch.findFirst(arr, arr[i]) + " ");
        }
        System.out.println();
    }

    public static void testStack()
    {
        Stack st = new LinkedList();
        for (int i = 0 ; i < 5; i++)
        {
            st.push(i);
        }
        while(!st.isEmpty())
        {
            System.out.print(" " + st.pop());
        }
        System.out.println();
    }

    public static void testHeap()
    {
        final int[] arr = IntegerGenerator.generateArray(30);
        print.printArray(arr);
        myHeap hp = new myHeap(arr);
        while(!hp.isEmpty())
        {
            System.out.print(hp.poll() + " ");
        }
        System.out.println();
        hp = new myHeap();
        for (int k : arr)
        {
            hp.offer(k);
        }
        while(!hp.isEmpty())
        {
            System.out.print(hp.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        testBinarySearch();
    }
}
