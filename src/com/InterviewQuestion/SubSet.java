package com.InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The classic problem related to subset
 *
 * @author Zhongya
 */
public class SubSet
{
    /*
        Problem Description:
        Given a set of distinct integers, nums, return all possible subsets (the power set).
        The solution set must not contain duplicate subsets.
    */

    public static List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        List<Integer> tmp = new ArrayList<>();
        subset(res, tmp, nums, 0);
        return res;
    }

    private static void subset(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx)
    {
        if (idx == nums.length)
        {
            res.add(new ArrayList<>(tmp));
            return;
        }
        subset(res, tmp, nums, idx + 1); // Not adding idx
        tmp.add(nums[idx]);  // Adding idx
        subset(res, tmp, nums, idx + 1);
        tmp.remove(tmp.size() - 1); // Backtracking
    }
    /*  Problem Description :
        Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     */

    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets2(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private static void subsets2(List<List<Integer>> res, List<Integer> tmp, int[] nums, int idx)
    {
        if (idx <= nums.length) res.add(new ArrayList<>(tmp));
        int i = idx;
        while (i < nums.length)
        {
            tmp.add(nums[i]);
            subsets2(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) i++;
        }
        return;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }
}
