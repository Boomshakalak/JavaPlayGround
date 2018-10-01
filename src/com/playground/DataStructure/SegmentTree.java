package com.playground.DataStructure;

class Node
{
    Node left;
    Node right;
    int l;
    int r;
    int sum;
    Node(int l, int r)
    {
        this.l = l;
        this.r = r;
    }
}

public class SegmentTree
{
    Node root;
    SegmentTree(int[] arr)
    {
        root = buildSegmentTree(arr, 0, arr.length - 1);
    }

    private Node buildSegmentTree(int[] arr, int l, int r)
    {
        if ( l > r) return null;
        Node root = new Node(l,r);
        if (l == r)
        {
            root.sum = arr[l];
            return root;
        }
        int m = (l + r) /2;
        root.left = buildSegmentTree(arr, l, m);
        root.right = buildSegmentTree(arr, m + 1, r);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int idx, int value)
    {
        update(root, idx, value);
    }

    private void update(Node root, int idx, int value)
    {
        if (root == null || idx > root.r || idx < root.l) return;
        if (root.l == idx && root.r == idx)
        {
            root.sum = value;
            return;
        }

        int m = (root.l + root.r)/2;
        if (idx <= m)
        {
            update(root.left, idx, value);
        }
        else
        {
            update(root.right, idx, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int querySum(int i, int j)
    {
        return querySum(root, i, j);
    }

    private int querySum(Node root, int i, int j)
    {
        if (i > j) return 0;
        if (root.l >= i && root.r <= j) return root.sum;
        int m = (root.l + root.r) / 2;
        if (i <= m && j > m)
        {
            return querySum(root.left,i,m) + querySum(root.right, m + 1, j);
        }

        if (j <= m) return querySum(root.left, i, j);
        if (i > m) return querySum(root.right, i, j);
        return 0;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,1,1,1,1,1};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(st.querySum(0,4) + " " + st.root.sum);
        st.update(3,2);
        System.out.println(st.querySum(1,1) + " " + st.querySum(3,3));
    }

}
