package com.InterviewQuestion;

import com.playground.DataStructure.Tree;
import com.playground.DataStructure.TreeNode;
import com.playground.TestGenerator.IntegerGenerator;
import com.playground.TestGenerator.TreeGenerator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Most commonly asked in a database related company
 *
 * @author Zhongya
 */
public class SerializeTree
{
    public static String serialize(TreeNode root)
    {
        if (root == null) return "null";
        String cur = "" + root.val;
        return cur + " " + serialize(root.left) + " " + serialize(root.right);

    }

    public static TreeNode deserialize(String tree)
    {
        String[] preorder = tree.split(" ");
        if (preorder.length == 0) return null;
        Deque<String> dq = new ArrayDeque<>(Arrays.asList(preorder));
        return deserialize(dq);
    }

    private static TreeNode deserialize(Deque<String> dq)
    {
        String tmp = dq.remove();
        if (tmp.equals("null")) return null;
        TreeNode cur = new TreeNode(Integer.parseInt(tmp));
        cur.left = deserialize(dq);
        cur.right = deserialize(dq);
        return cur;
    }

    // Follow up : If the stack space is limited, can you do it iteratively

    public static String iserialize(TreeNode root)
    {
        if (root == null) return "null";
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
        {
            TreeNode cur = st.pop();
            if (cur == null) sb.append("null ");
            else
            {
                sb.append(cur.val + " ");
                st.push(cur.right);
                st.push(cur.left);
            }
        }
        return sb.toString();
    }

    public static TreeNode ideserialize(String tree)
    {
        Stack<Integer> si = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        String[] nodes = tree.split(" ");
        if (nodes.length == 0 || nodes[0].equals("null")) return null;
        Deque<String> dq = new ArrayDeque<>(Arrays.asList(nodes));
        TreeNode root = new TreeNode(Integer.parseInt(dq.remove()));
        st.push(root);
        si.push(0);
        while (!st.isEmpty())
        {
            String tmp = dq.remove();
            if (tmp.equals("null"))
            {
                st.push(null);
                si.push(2);
            }
            else
            {
                st.push(new TreeNode(Integer.parseInt(tmp)));
                si.push(0);
            }
            while (si.peek() == 2)
            {
                TreeNode cur = st.pop();
                si.pop();
                if (st.isEmpty()) break;
                TreeNode prev = st.peek();
                int status = si.pop();
                switch (status)
                {
                    case 0:
                        prev.left = cur;
                        si.push(1);
                        break;
                    case 1:
                        prev.right = cur;
                        si.push(2);
                    default:
                        break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args)
    {
        TreeNode root = TreeGenerator.generateBSTFromArray(IntegerGenerator.DEFAULT_GENERATOR.getArray(20));
        String s = iserialize(root);
        System.out.println(s);
        System.out.println(Tree.isSameTree(ideserialize(s), root));
    }
}
