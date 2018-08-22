package com.playground.DataStructure;

/**
 * Simple Trie tree implementation
 * @author zhongya
 */

class TrieNode
{
    boolean isEnd;
    TrieNode[] array;
    TrieNode()
    {
        isEnd = false;
        array = new TrieNode[256];
    }
}
public class TrieTree
{
    TrieNode root;
    TrieTree()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode cur = root;
        for( int i = 0; i < word.length(); i++)
        {
            int idx = word.charAt(i);
            if (cur.array[idx] == null)
            {
                cur.array[idx] = new TrieNode();
                cur = cur.array[idx];
            }
        }
        cur.isEnd = true;
    }

    public boolean find(String word)
    {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length(); i++)
        {
            int idx =word.charAt(i);
            if (cur.array[idx] == null) return false;
            cur = cur.array[idx];
        }
        return cur.isEnd;
    }

    public void remove(String word)
    {
        TrieNode cur = root;
        for (int i = 0 ; i < word.length(); i++)
        {
            int idx =word.charAt(i);
            if (cur.array[idx] == null) return;
            cur = cur.array[idx];
        }
        cur.isEnd = false;
    }

    public static void main(String[] args)
    {
        TrieTree prefixTree = new TrieTree();
        prefixTree.insert("Adam");
        System.out.println(prefixTree.find("Adam") + " " + prefixTree.find("Tony"));
        prefixTree.remove("Adam");
        System.out.println(prefixTree.find("Adam") + " " + prefixTree.find("Tony"));

    }
}
