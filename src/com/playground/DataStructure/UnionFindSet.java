package com.playground.DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Union Find Set using node (can use array but array cannot explain the concept well)
 * Use a map to support find by id, not very graceful
 * @author zhongya
 */

class UFNode
{
    int val;
    int rank;
    UFNode parent;
    UFNode(int val)
    {
        this.val = val;
        parent = this;
        this.rank = 0;
    }
}
public class UnionFindSet
{
    Map<Integer, UFNode> nodeMap;
    UnionFindSet()
    {
        nodeMap = new HashMap<>();
    }

    public int makeSet(int k)
    {
        UFNode node = nodeMap.get(k);
        if (node == null)
        {
            UFNode newNode = new UFNode(k);
            nodeMap.put(k, newNode);
        }
        else
        {
            node.parent = node;
            node.rank = 0;
        }
        return k;
    }

    public int find(int k)
    {
        UFNode node = nodeMap.get(k);
        if (node == null) return -1;
        if (node.parent == node) return node.val;
        int root = find(node.parent.val);
        node.parent = nodeMap.get(root);
        return root;
    }

    public void union(int x, int y)
    {
        int xroot = find(x);
        if (xroot == -1) xroot = makeSet(x);
        int yroot = find(y);
        if (yroot == -1) yroot = makeSet(y);
        if (xroot == yroot) return;
        else
        {
            UFNode nodex = nodeMap.get(xroot);
            UFNode nodey = nodeMap.get(yroot);
            if (nodex.rank < nodey.rank)
            {
                nodex.parent = nodey;
            }
            else if (nodex.rank > nodey.rank)
            {
                nodey.parent =nodex;
            }
            else
            {
                nodex.parent = nodey;
                nodey.rank++;
            }
        }
    }

    public static void main(String[] args)
    {
        UnionFindSet ufs = new UnionFindSet();
        // 0-9 one set
        ufs.makeSet(5);
        for (int i = 0 ; i < 9; i++)ufs.union(i, 5);
        for (int i = 11; i < 99; i++) ufs.union(10, i);
        System.out.println("Number 3 parent :" + ufs.find(3));
        System.out.println("Number 50 parent :" + ufs.find(15));
        ufs.union(3,50);
        System.out.println("After merge Number 3 parent :" + ufs.find(3));
        System.out.println("After merge Number 50 parent :" + ufs.find(50));
    }
}
