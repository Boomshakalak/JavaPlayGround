package com.playground.DataStructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree
{
    protected TreeNode root;

    public Tree(TreeNode root)
    {
        this.root = deepCopyTree(root);

    }

    public TreeNode getRoot()
    {
        return this.root;
    }

    public static TreeNode deepCopyTree(TreeNode root)
    {
        if (root == null) return null;
        else
        {
            TreeNode node = new TreeNode(root.val);
            node.left = deepCopyTree(root.left);
            node.right = deepCopyTree(root.right);
            return node;
        }
    }

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

    public static List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null)
        {
            if (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            else
            {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    public static List<Integer> postOrderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode cur = stack.peek();
            if (prev == null || cur == prev.left || cur == prev.right)
            {
                if (cur.left != null)
                {
                    stack.push(cur.left);
                }
                else if (cur.right != null)
                {
                    stack.push(cur.right);
                }
                else
                {
                    res.add(stack.pop().val);
                }
            }
            else if (prev == cur.left && cur.right == null || prev == cur.right)
            {
                res.add(stack.pop().val);
            }
            else
            {
                stack.push(cur.right);
            }
            prev = cur;
        }
        return res;
    }

    public static boolean isSameTree(TreeNode a, TreeNode b)
    {
        if (a == null || b == null) return a == b;
        if (a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
