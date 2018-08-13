package com.playground.Algorithm;

/**
 * Sort class for sorting integer Array
 * @author zhongya
 */
public class Sort {

    public static int[] selectionSort(int[] array)
    {
        if (array == null || array.length < 2) return array;
        for (int i = 0; i < array.length - 1; i++)
        {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[min_index])
                {
                    min_index = j;
                }
            }
            swap(array, i, min_index);
        }
        return array;
    }

    public static int[] mergeSort(int[] array)
    {
        if (array == null || array.length < 2) return array;
        int sz = array.length;
        mergeSort(array, 0, sz);
        return array;
    }

    private static void mergeSort(int[] array, int l, int r)
    {
        if ( r - l < 2) return;
        int m = l + (r - l) / 2;
        mergeSort(array, l , m);
        mergeSort(array, m, r);
        merge(array, l , m, r);
    }

    private static void merge(int[] array, int l, int m, int r)
    {
        int[] nArray = new int[r - l];
        System.arraycopy(array, l, nArray, 0, r - l);
        int idx = l;
        int ptr1 = 0;
        int ptr2 = m - l;
        while(ptr1 < m - l && ptr2 < r - l)
        {
            array[idx++] = nArray[ptr1] < nArray[ptr2] ? nArray[ptr1++] : nArray[ptr2++];
        }
        while (ptr1 < m - l)
        {
            array[idx++] = nArray[ptr1++];
        }
        while (ptr2 < r - l)
        {
            array[idx++] = nArray[ptr2++];
        }
    }

    public static int[] quickSort(int[] array)
    {
        if (array == null || array.length < 2) return array;
        int sz = array.length;
        quickSort(array, 0, sz);
        return array;
    }

    private static void quickSort(int[] array, int l, int r)
    {
        if ( r - l < 2) return;
        int pivotIndex = getPivotIndex(l, r);
        int pivot = array[pivotIndex];
        int j = r - 2;
        int cur_idx = l;
        swap(array, pivotIndex, r - 1);
        while (cur_idx <= j)
        {
            int cur = array[cur_idx];
            if (cur < pivot) {
                cur_idx++;
            }
            else
            {
                swap(array, j--, cur_idx);
            }
        }
        // Everything after j will be larger than pivot
        swap(array, j + 1, r - 1); // Swap pivot to the right place
        quickSort(array, l, j + 1);
        quickSort(array, j + 2, r );
    }

    /**
     * The strategy for getting a pivot, currently using the index in the mid
     * @param l the left bound
     * @param r the right bound
     * @return the pivot index
     */
    private static int getPivotIndex(int l, int r)
    {
        return l + (r - l)/2;
    }

    /**
     * Swap two elements in an array
     * @param array the array
     * @param i the first element to be swapped
     * @param j the second element to be swapped
     */
    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
