package com.playground.TestGenerator;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Generate random integers, also can serve for other random things
 * @author zhongya
 */

public class RandomIntegerGenerator {
    private int lower_bound;
    private int upper_bound;
    public RandomIntegerGenerator()
    {
        lower_bound = 0;
        upper_bound = Integer.MAX_VALUE;
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
        return (int)(Math.random()* (upper_bound - lower_bound) + lower_bound);
    }

    public List<Integer> getList(int n)
    {
        if ( n < 0)
        {
            throw new InvalidParameterException( "n should be a non- negative number");
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < n ; i++)
        {
            res.add(nextInt());
        }
        return res;
    }
}
