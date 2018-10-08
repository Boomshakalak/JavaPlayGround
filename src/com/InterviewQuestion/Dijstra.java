package com.InterviewQuestion;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Sample code for using Dijstra algorithm
 * @author zhongya
 */

/*
    Problem Description :
        Given a 2d matrix with numbers in it, find a path from left top to right bottom with minimum cost
        Example:
        matrix = [1 2 3]
                 [0 0 1]
        output = 2
 */
public class Dijstra
{

    static class Node
    {
        int x;
        int y;
        int val;
        Node(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    /*
        Time O(V + ElgE)
        Space O(V + E)
        KeyPoint : we never update the value in the PriorityQueue since we have a visited set, we are guaranteed
        the space will not exceed # of edges
     */
    public static int dijstra(int[][] matrix)
    {
        int[][] dirs = {{0,1}, {0 , -1}, {1, 0}, {-1, 0}};
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return -1;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->
                                                     {
                                                         return a.val - b.val;
                                                     });
        Set<String> visited = new HashSet<>();
        pq.offer(new Node(0,0, matrix[0][0]));
        while(!pq.isEmpty())
        {
            Node cur = pq.poll();
            visited.add(getString(cur.x, cur.y));
            if (cur.x == matrix.length - 1 && cur.y == matrix[0].length - 1) return cur.val;
            else
            {
                for (int[] dir : dirs)
                {
                    int nx = cur.x + dir[0];
                    int ny = cur.y + dir[1];
                    if (nx < 0 || nx >= matrix.length || ny < 0
                            || ny >= matrix[0].length || visited.contains(getString(nx, ny))) continue;
                    pq.offer(new Node(nx, ny, cur.val + matrix[nx][ny]));
                }
            }
        }
        return -1;
    }

    private static String getString(int x, int y)
    {
        return x + "," + y;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3}, {0, 0, 1}};
        System.out.println(dijstra(matrix));
    }
}
