package com.InterviewQuestion;


import java.util.HashMap;
import java.util.Map;

/**
 * This is a template how to have a well documented question
 */

/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    Example :
    Given nums = [2, 7, 11, 15], target = 9,
    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 */

public class TwoSum
{
    /*
        Space O(n)  Time O(n)  n -> the length of the array
        KeyPoint : Using a hashmap to memorize the previous elements we have visited,
        if we see a match then we return the result
    */

    public static int[] twoSum(int[] arr, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            int cur = arr[i];
            if (map.containsKey(target - cur))
            {
                int[] res = new int[2];
                res[0] = map.get(target - cur);
                res[1] = i;
                return res;
            }
            map.put(cur, i);
        }
        return null;
    }
}
