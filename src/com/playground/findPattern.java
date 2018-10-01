package com.playground;

import com.util.print;

/**
 * Find the similarity of two strings, just for fun
 * @author zhongya
 */
public class findPattern
{
    public static void findStringPattern(String a, String b)
    {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) return;
        int[] diff = new int[a.length()];
        int[] absa = new int[a.length()];
        int[] absb = new int[a.length()];
        for (int i = 0 ; i < a.length(); i++)
        {
            diff[i] = a.charAt(i) - b.charAt(i);
            absa[i] = a.charAt(i) - 'a';
            absb[i] = b.charAt(i) - 'a';
        }
        System.out.println("diff array:");
        print.printArray(diff);
        System.out.println("first array:");
        print.printArray(absa);
        System.out.println("second array:");
        print.printArray(absb);
    }

    public static void main(String[] args)
    {
        String a = "right";
        String b = "pgefr";
        findStringPattern(a, b);
    }
}
