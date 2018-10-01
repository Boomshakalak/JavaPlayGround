package com.playground.TestGenerator;

import com.playground.Algorithm.Sort;
import com.playground.DataStructure.TreeNode;

/**
 * Offer some functionality to generate some trees
 * @author zhongya
 */

public class TreeGenerator
{
    /**
     * Generate a binary search tree from a
     * @param array
     * @return the root of the BST
     */
    public static TreeNode generateBSTFromArray(int[] array)
    {
        if (array == null) return null;
        int sz = array.length;
        Sort.mergeSort(array);
        return generateBalanceTreeFromArray(array, 0, sz);
    }

    public static TreeNode generateBalanceTreeFromArray(int[] array)
    {
        if (array == null) return null;
        int sz = array.length;
        return generateBalanceTreeFromArray(array, 0, sz);
    }

    private static TreeNode generateBalanceTreeFromArray(int[] array, int l, int r)
    {
        if ( l >= r) return null;
        if (l == r - 1) return new TreeNode(array[l]);
        int m = l + (r - l)/2;
        TreeNode root = new TreeNode(array[m]);
        root.left = generateBalanceTreeFromArray(array, l, m);
        root.right = generateBalanceTreeFromArray(array, m + 1, r);
        return root;
    }
}
