package com.InterviewQuestion;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
    class Node
    {
        Node prev;
        Node next;
        int key;
        int val;

        Node(int k, int v)
        {
            key = k;
            val = v;
        }
    }

    Node head;
    Node tail;
    int cap;
    int count;
    Map<Integer, Node> map;

    private void add(Node n)
    {
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
        count++;
    }

    private void delete(Node n)
    {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        count--;
    }

    private void update(Node n)
    {
        delete(n);
        add(n);
    }

    public LRUCache(int capacity)
    {
        cap = capacity;
        count = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.next = head;
        map = new HashMap<>();
    }

    public int get(int key)
    {
        Node cur = map.get(key);
        if (cur != null)
        {
            update(cur);
            return cur.val;
        }
        return -1;
    }

    public void put(int key, int value)
    {
        Node cur = map.get(key);
        if (cur != null)
        {
            cur.val = value;
            update(cur);
        }
        else
        {
            Node n = new Node(key, value);
            map.put(key, n);
            if (count == cap)
            {
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            add(n);
        }
    }
}
