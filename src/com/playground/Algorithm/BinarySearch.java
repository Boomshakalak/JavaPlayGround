package com.playground.Algorithm;

/**
 * For this class, we always asume the input is sorted ascending order
 * @author zhongya
 */
public class BinarySearch
{
    public static int find(int[] array, int target)
    {
        if (array == null || array.length == 0) return -1;
        int l = 0;
        int r = array.length - 1;
        while (l < r)
        {
            int m = l + (r - l) / 2;
            if (array[m] == target) return m;
            if (array[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    public static int findFirst(int[] array, int target)
    {
        if (array == null || array.length == 0) return -1;
        int l = 0;
        int r = array.length - 1;
        while(l < r - 1)
        {
            int m = l + (r - l)/2;
            if (array[m] < target)
            {
                l = m + 1;
            }
            else r = m;
        }
        if (array[l] == target) return l;
        if (array[r] == target) return r;
        return -1;
    }

    public static int findLast(int[] array, int target)
    {
        if (array == null || array.length == 0) return -1;
        int l = 0;
        int r = array.length - 1;
        while (l < r - 1)
        {
            int m = l + (r - l)/2;
            if (array[m] > target)
            {
                r = m - 1;
            }
            else l = m;
        }
        if (array[r] == target) return r;
        if (array[l] == target) return l;
        return -1;
    }
}
