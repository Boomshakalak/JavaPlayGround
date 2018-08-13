package com.playground.DataStructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree
{
    private TreeNode root;
    public static List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null)
            {
                stack.push(cur.right);
            }
            if (cur.left != null)
            {
                stack.push(cur.left);
            }
        }
        return res;
    }
}
