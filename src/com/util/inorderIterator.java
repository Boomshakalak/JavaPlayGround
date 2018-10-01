package com.util;

import com.playground.DataStructure.BSTNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class inorderIterator implements Iterator
{
    private BSTNode current;
    private Deque<BSTNode> stack;

    public inorderIterator(BSTNode root)
    {
        current = root;
        stack = new LinkedList<>();
    }


    @Override
    public int next()
    {
        if (!hasNext()) throw new NoSuchElementException("BSTIterator::next : cannot find the next element");
        while(current != null)
        {
            stack.push(current);
            current = current.left;
        }
        BSTNode node = stack.pop();
        current = node.right;
        return node.val;
    }

    @Override
    public boolean hasNext()
    {
        return current != null || !stack.isEmpty();
    }
}
