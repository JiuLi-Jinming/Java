package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class list
{
     // Definition for singly-linked list.
     public class ListNode
     {
          int val;
          ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2)
        {
            ListNode temp = new ListNode(0);
            ListNode cur = temp;

            while (l1 != null || l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else if (l2.val < l1.val) {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }

            if (l1 == null) {
                temp.next = l2;
            } else if (l2 == null) {
                temp.next = l1;
            }
            return temp;
        }

    /**
     * 15. 三数之和
     */
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i >= 0 && nums[i] != nums[i-1])){
                int l=i+1, r=nums.length-1, sum = -nums[i];

                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r-1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l+1]) l++;
                        l++;
                    } else {
                        while (l < r && nums[r-1] == nums[r]) r--;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
