package ptatics.arr;

public class arr
{
    // 26.删除排序数组中的重复项(simple)
    public int removeDuplicates(int[] nums)
    {
        if(nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while(q < nums.length){
            if(nums[p] != nums[q]){
                /*
                nums = [0,1,2,3,4,5]
                此时数组中没有重复元素，按照上面的方法，每次比较时 nums[p] 都不等于 nums[q]，因此就会将 q 指向的元素原地复制一遍，这个操作其实是不必要的。
                因此我们可以添加一个小判断，当 q - p > 1 时，才进行复制。
                iff nums[p] == nums[q]  q+1 --> q-p >1, iff nums[p] != nums[q]  q+0 --> q-p = 0.
                 */
                if(q - p > 1){
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
        /*
         * 作者：max-LFszNScOfE
         * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        */
    }
    /**
     * 27. 移除元素
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int q=0; q < nums.length; q++) {
            if(nums[q] != val) {
                nums[p++] = nums[q];
            }
        }
        return p;
    }
}
