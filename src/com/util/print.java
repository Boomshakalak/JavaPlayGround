package com.util;

import com.playground.DataStructure.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class print
{

    public static void printArray(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return;
        }
        List<Integer> integers = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(integers);
    }

    public static void printTree(TreeNode root)
    {
    }
}
