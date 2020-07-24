public class merge_divide
{
    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers)
    {
        if (numbers.length < 2) return numbers[0];
        int len = numbers.length;
        int left = 0, right = len - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (numbers[mid] > numbers[right]) {
                left = mid +1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * 4. 寻找两个正序数组的中位数
     *
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.length, n = nums2.length;
        int left = (m+n+1) / 2;
        int right = (m+n+2) / 2;

        return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     * find the Kth number;
     * @param nums1
     * @param i start of nums1;
     * @param nums2
     * @param j start of nums2;
     * @param k
     * @return
     */
    private int findK(int[] nums1, int i, int[] nums2, int j, int k)
    {
        if (i >= nums1.length) return nums2[j+k-1];
        if (j >= nums2.length) return nums1[i+k-1];
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int midVal1 = (i+k/2-1) < nums1.length ? nums1[i+k/2-1] : Integer.MAX_VALUE;
        int midVal2 = (j+k/2-1) < nums2.length ? nums2[j+k/2-1] : Integer.MAX_VALUE;

        if (midVal1 < midVal2) {
            return findK(nums1, i+k/2, nums2, j, k-k/2);
        } else {
            return findK(nums1, i, nums2, j+k/2, k-k/2);
        }
    }
}
