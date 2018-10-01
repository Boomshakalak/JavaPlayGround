import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public int sol(int k, String str) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int i = 0;
        int j = 0;
        while ( j < str.length())
        {
            while (map.size() < k)
            {
                char cur = str.charAt(j++);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
            while (map.size() >= k)
            {
                if (map.size() == k) count++;
                char cur = str.charAt(i++);
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) map.remove(cur);
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        String a = "";
        return;
    }
}


