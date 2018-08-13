package com.example;

import com.playground.Algorithm.Sort;
import com.playground.DataStructure.LinkedList;
import com.playground.DataStructure.ListNode;
import com.playground.TestGenerator.RandomIntegerGenerator;
import com.util.Print;

public class usingInternalLibrary {

    public static void selectionSortArray()
    {
        int[] test = RandomIntegerGenerator.generateArray(15);
        Sort.selectionSort(test);
        Print.PrintArray(test);
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
}
