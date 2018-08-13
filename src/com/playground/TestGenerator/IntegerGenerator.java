package com.playground.TestGenerator;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Generate random integers, also can serve for other random things
 * @author zhongya
 */

public class IntegerGenerator
{
    private int lower_bound;
    private int upper_bound;
    public static final int[] TEN = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static IntegerGenerator DEFAULT_GENERATOR =
            new IntegerGenerator(-1000 , 1001);
    public IntegerGenerator()
    {
        lower_bound = -1000;
        upper_bound = 1001;
    }

    public IntegerGenerator(int lower_bound, int upper_bound)
    {
        this.lower_bound = lower_bound;
        this.upper_bound = upper_bound;
    }

    public void setLower_bound(int lower_bound)
    {
        this.lower_bound = lower_bound;
    }

    public void setUpper_bound(int upper_bound)
    {
        this.upper_bound = upper_bound;
    }

    public int nextInt()
    {
        return (int)(Math.random()* ((long)upper_bound - (long)lower_bound) + lower_bound);
    }

    /**
     * Generate a random list of a fixed size
     * @param size
     * @return
     */
    public List<Integer> getList(int size)
    {
        if ( size < 0)
        {
            throw new InvalidParameterException( "n should be a non- negative number");
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < size ; i++)
        {
            res.add(nextInt());
        }
        return res;
    }

    public int[] getArray(int size)
    {
        if ( size < 0)
        {
            throw new InvalidParameterException( "n should be a non- negative number");
        }
        int[] res = new int[size];
        for (int i = 0 ; i < size ; i++)
        {
            res[i] = nextInt();
        }
        return res;
    }

    /**
     * Static function for generating a list of given range and size
     * @param lower_bound
     * @param upper_bound
     * @param size
     * @return
     */

    public static List<Integer> generateList(int lower_bound, int upper_bound, int size)
    {
        IntegerGenerator rig = new IntegerGenerator(lower_bound, upper_bound);
        return rig.getList(size);
    }

    public static List<Integer> generateList(int size)
    {
        return DEFAULT_GENERATOR.getList(size);
    }

    public static int[] generateArray(int lower_bound, int upper_bound, int size)
    {
        IntegerGenerator rig = new IntegerGenerator(lower_bound, upper_bound);
        return rig.getArray(size);
    }

    public static int[] generateArray(int size)
    {
        return DEFAULT_GENERATOR.getArray(size);
    }
}
