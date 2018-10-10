package com.InterviewQuestion;

public class EggDrop
{
    /*
        Egg dropping refers to a class of problems in which it is important to find the correct response without
        exceeding a (low) number of certain failure states. In a toy example, there is a tower of n floors, and an egg
        dropper with m ideal eggs. The physical properties of the ideal egg is such that it will shatter if it is
        dropped from x floor or above, and will have no damage whatsoever if it is dropped from x - 1 floor or below.
        The problem is to find a strategy such that the egg dropper can determine the floor  in as few egg drops as possible.
        This problem has many applications in the real world such as avoiding a call out to the slow HDD,
        or attempting to minimize cache misses, or running a large number of expensive queries on a database.
     */

    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors */
    public static int eggDrop(int n, int k)
    {
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        for (i = 0; i <= n; i++)
        {
            eggFloor[i][0] = 0;
        }

        for (i = 0; i <= k; i++)
        {
            eggFloor[1][i] = i;
            eggFloor[0][k] = 0;
        }

        for (i = 2; i <= n; i++)
        {
            for (j = 1; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++)
                {
                    res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
    }

    /*
        It has a better binomial solution which is not required for most of people,
        if you are interested, search it on Google
     */

    public static void main(String[] args)
    {
        System.out.println(eggDrop(2, 15));
    }
}
