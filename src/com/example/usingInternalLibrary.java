package com.example;

import com.playground.Algorithm.Sort;
import com.playground.DataStructure.LinkedList;
import com.playground.DataStructure.ListNode;
import com.playground.DataStructure.Tree;
import com.playground.DataStructure.TreeNode;
import com.playground.TestGenerator.IntegerGenerator;
import com.playground.TestGenerator.TreeGenerator;
import com.util.Print;


public class usingInternalLibrary {

    public static void selectionSortArray()
    {
        int[] test = IntegerGenerator.generateArray(15);
        Sort.selectionSort(test);
        Print.PrintArray(test);
    }

    public static void mergeSortArray()
    {
        int[] test = IntegerGenerator.generateArray(15);
        Sort.mergeSort(test);
        Print.PrintArray(test);
    }

    public static void quickSortArray()
    {
        int[] test = IntegerGenerator.generateArray(15);
        Sort.quickSort(test);
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

    public static void testHashMap()
    {
    }

    public static void testTree()
    {
        TreeNode root = TreeGenerator.generateBSTFromArray(IntegerGenerator.TEN);
        System.out.println(root.val);
        System.out.println(Tree.preorderTraversal(root));
    }
}
