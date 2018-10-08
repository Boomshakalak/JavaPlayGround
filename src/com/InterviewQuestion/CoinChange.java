package com.InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange
{
    /*
        Problem discription:
            You are given coins of different donominations and a total amount of money. Write a function to enumerate all
            possible combinations that can make up of that amount.
            Inupt int[] arr  int amount
     */
    public static List<List<Integer>> coinChange(int amount, int[] coins)
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        getCombination(res, tmp, coins, amount, 0);
        return res;
    }

    private static void getCombination(List<List<Integer>> res, List<Integer> tmp, int[] coins, int remain, int idx)
    {
        if (idx == coins.length)
        {
            if (remain == 0) res.add(new ArrayList<>(tmp));
        }
        else
        {
            for (int i = 0; i * coins[idx] <= remain; i++)
            {
                tmp.add(i);
                getCombination(res, tmp, coins, remain - i * coins[idx], idx + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    /*
        Coin Change V2
        You are given coins of different denominations and a total amount of money amount. Write a function to
        compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be
        made up by any combination of the coins, return -1.

        Example 1:

        Input: coins = [1, 2, 5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1
        Example 2:

        Input: coins = [2], amount = 3
        Output: -1
    */

    /*
        To know the minimum amount of coins needed for the amount, we can infer the problem from its sub problem.
        For coins = [ 1, 2, 5] the least money that made up of m, must be either from the solution of m - 1, m -2
        or m - 5.
        Thus we need to initialize the dp array with everything set the maximum and if we can solve one of the sub problem,
        we get a solution for the bigger problem
        Time (O(amount) * O(coins.length))
        Space  O(amount)
     */

    public static int coinChange2(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++)
        {
            for (int c : coins)
            {
                if (i - c >= 0 && dp[i - c] < Integer.MAX_VALUE)
                {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /*
        Problem Description:
        You are given coins of different denominations and a total amount of money.
        Write a function to compute the number of combinations that make up that amount.
        You may assume that you have infinite number of each kind of coin.
     */

    public static int coinChange3(int amount, int[] coins)
    {
        if (coins.length == 0)
        {
            if (amount == 0) return 1;
            return 0;
        }
        // dp[i][j] : : # of the ways of using the first i denominations to make up the amount j
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++)
        {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                dp[i][j] += dp[i - 1][j];
                if (j >= coins[i - 1])
                {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public static void main(String[] args)
    {
        int[] coins = {1, 2, 5};
        List<List<Integer>> res = coinChange(15, coins);
        for (List<Integer> list : res)
        {
            System.out.println(list);
        }
    }
}
