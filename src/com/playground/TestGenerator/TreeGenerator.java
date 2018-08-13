package com.playground.TestGenerator;

import com.playground.Algorithm.Sort;
import com.playground.DataStructure.TreeNode;

public class TreeGenerator
{
    /**
     * Generate a binary search tree from a
     * @param array
     * @return
     */
    public static TreeNode generateBSTFromArray(int[] array)
    {
        if (array == null) return null;
        int sz = array.length;
        Sort.mergeSort(array);
        return generateBSTFromArray(array, 0, sz);
    }

    private static TreeNode generateBSTFromArray(int[] array, int l, int r)
    {
        if ( l >= r) return null;
        if (l == r - 1) return new TreeNode(array[l]);
        int m = l + (r - l)/2;
        TreeNode root = new TreeNode(array[m]);
        root.left = generateBSTFromArray(array, l, m);
        root.right = generateBSTFromArray(array, m + 1, r);
        return root;
    }
}
