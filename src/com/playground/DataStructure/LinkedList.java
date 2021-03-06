package com.playground.DataStructure;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * LinkedList class using our self defined ListNode
 * @author zhongya
 */

public class LinkedList implements Stack, Queue, Deque {
    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(ListNode n)
    {
        if (n == null)
        {
            return;
        }
        size++;
        if (tail == null)
        {
            head = n;
            tail = n;
        }
        else
        {
            tail.next = n;
            tail = n; // doesn't set the tail's next because we allow loop to adapt more general purpose
        }
    }

    public void add(int n)
    {
        add(new ListNode(n));
    }

    public void addFromHead(ListNode n)
    {
        if (n == null)
        {
            throw new NullPointerException("LinkedList::AddFromHead : Cannot add a nullptr at the beginning of a linked list");
        }
        size++;
        n.next = head;
        head = n;
    }

    public void addFromHead(int n)
    {
        addFromHead(new ListNode(n));
    }

    public ListNode getHead()
    {
        return head;
    }

    public ListNode getTail()
    {
        return tail;
    }

    @Override
    public void enqueue(int k)
    {
        add(k);
    }

    @Override
    public int dequeue()
    {
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    @Override
    public int peekFirst()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Cannot peek an empty container");
        }
        return head.val;
    }

    @Override
    public int peekLast()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Cannot peek an empty container");
        }
        return tail.val;
    }

    @Override
    public int pollFirst()
    {
        return dequeue();
    }

    @Override
    public int pollLast()
    {
        return pop();
    }

    @Override
    public void offerFirst(int k)
    {
        addFromHead(k);
    }

    @Override
    public void offerLast(int k)
    {
        add(k);
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public int peek()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Cannot peek an empty container");
        }
        return head.val;
    }

    @Override
    public int pop()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Cannot peek an empty container");
        }
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    @Override
    public void push(int k)
    {
        addFromHead(k);
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        if (size() == 0) return "[]";
        sb.append("[");
        ListNode cur = head;
        Set<ListNode> nodes = new HashSet<>();
        while(cur.next != null)
        {
            sb.append(cur.val + "->");
            if (nodes.contains(cur))
            {
                sb.append("... ]");
                return sb.toString();
            }
            nodes.add(cur);
            cur = cur.next;
        }
        if (cur != null)
        {
            sb.append(cur.val + "]");
        }
        return sb.toString();
    }
}
