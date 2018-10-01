package com.playground.DataStructure;

public class BSTNode
{
    public int val;
    public int height;
    public BSTNode left;
    public BSTNode right;

    BSTNode(int val)
    {
        this.val = val;
        this.height = 1;
    }
}
