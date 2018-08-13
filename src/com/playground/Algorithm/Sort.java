package com.playground.Algorithm;

/**
 * Sort class for sorting integer Array
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


    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
