package com.playground.DataStructure;

import com.playground.TestGenerator.IntegerGenerator;
import com.util.inorderIterator;

import java.util.List;

/**
 * BST that support self balance (a.k.a AVL tree)
 * IMPORTANT: Every number in this tree should be unique
 * @author zhongya
 */

public class BinarySearchTree
{
    private BSTNode root;

    private int size;

    public BinarySearchTree()
    {
        root = null;
        size = 0;
    }

    public BSTNode getRoot()
    {
        return this.root;
    }

    private int height(BSTNode node)
    {
        if (node == null)
            return 0;
        return node.height;
    }

    BSTNode rightRotate(BSTNode y)
    {
        BSTNode x = y.left;
        BSTNode T2 = x.right;
        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    BSTNode leftRotate(BSTNode x)
    {
        BSTNode y = x.right;
        BSTNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    int getBalance(BSTNode node)
    {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    public void insert(int val)
    {
        root = insert(root,val);
    }
    private BSTNode insert(BSTNode node, int val)
    {
        if (node == null)
        {
            size++;
            return (new BSTNode(val));
        }
        if (val < node.val) node.left = insert(node.left, val);
        else if (val > node.val) node.right = insert(node.right, val);
        else return node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        if (balance > 1 && val < node.left.val) return rightRotate(node);
        if (balance < -1 && val > node.right.val) return leftRotate(node);
        if (balance > 1 && val > node.left.val)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && val < node.right.val)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    BSTNode minValueNode(BSTNode node)
    {
        BSTNode current = node;
        while (current.left != null)
            current = current.left;

        return current;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public boolean find(int key)
    {
        return find(root, key);
    }

    private boolean find(BSTNode root, int key)
    {
        if (root == null) return false;
        if (root.val == key) return true;
        if (root.val > key) return find(root.left, key);
        return find(root.right, key);
    }

    public void delete(int key)
    {
        if (find(key)) size--;
        root = delete(root, key);
    }

    private BSTNode delete(BSTNode root, int key)
    {
        if (root == null) return null;
        if (key < root.val) root.left = delete(root.left, key);
        else if (key > root.val) root.right = delete(root.right, key);
        else
        {
            if ((root.left == null) || (root.right == null))
            {
                BSTNode temp;
                if (root.left == null)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null)
                {
                    root = null;
                }
                else root = temp;

            }
            else
            {
                BSTNode temp = minValueNode(root.right);
                root.val = temp.val;
                root.right = delete(root.right, temp.val);
            }
        }
        if (root == null) return null;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static boolean isValidBST(BSTNode root)
    {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(BSTNode root, int min, int max)
    {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }


    public static void main(String[] args)
    {
        List<Integer> li = IntegerGenerator.generateList(10);
        BinarySearchTree tree = new BinarySearchTree();
        for (int k : li )
        {
            tree.insert(k);
        }
        System.out.println(tree.size());
        inorderIterator itr = new inorderIterator(tree.getRoot());
        while(itr.hasNext())
        {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        tree.delete(tree.getRoot().val);
        tree.delete(1);
        System.out.println(tree.size());
        inorderIterator itr2 = new inorderIterator(tree.getRoot());
        while(itr2.hasNext())
        {
            System.out.print(itr2.next() + " ");
        }
        System.out.println();
        System.out.println(isValidBST(tree.getRoot()));
    }
}


