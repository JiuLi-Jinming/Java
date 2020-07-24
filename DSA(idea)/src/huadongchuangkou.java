public class huadongchuangkou
{
    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums)
    {
        int l = 0, r = 0, sum = 0, len = 0;

        while (r < nums.length) {
            sum += nums[r++];

            while (sum >= s) {
                len = len==0 ? r-l : Math.min(len, r-l);
                sum -= nums[l++];
            }
        }
        return len;
    }
}
