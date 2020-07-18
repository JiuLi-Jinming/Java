import java.util.*;

public class hashtyped
{
    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No tow sum solution");
    }

    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s)
    {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int rk =-1, maxLen =0;

        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                set.remove(chars[i-1]);
            }
            while (rk+1 < s.length() && !set.contains(chars[rk+1])) {
                set.add(chars[rk+1]);
                rk++;
            }
            maxLen = Math.max(maxLen, rk-i + 1);
        }
        return maxLen;
    }


}
