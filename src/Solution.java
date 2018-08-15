import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ; i < nums.length - 2; i++)
        {
            if ( i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k)
            {
                int cur = nums[i] + nums[j] + nums[k];
                if (cur < 0) j++;
                else if (cur > 0) k--;
                else
                {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j + 1] == nums[j]) j++;
                    while(j < k && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                }
            }
        }
        return res;
    }
}
