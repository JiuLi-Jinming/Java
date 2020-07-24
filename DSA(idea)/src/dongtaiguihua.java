import org.jetbrains.annotations.NotNull;
import tree.Trie;

import javax.swing.tree.TreeNode;
import java.util.*;

public class dongtaiguihua
{
    /*
    53. 最大子序和
     */
    public int maxSubArray(int[] nums)
    {
        int sum = 0;
        int maxVal = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0)
                sum = nums[i];
            else
                sum += nums[i];

            maxVal = Math.max(sum,maxVal);
        }
        return maxVal;
    }

/*
121. 买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。
 */
    public int maxProfit1(int[] prices)
    {
        int len = prices.length;
        
        int max = 0, min = prices[0];

        for (int i = 1; i < len; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    /*
    *   122. 买卖股票的最佳时机 II
    *   同121， 但可以多次买卖，求最大利润
    *
    * */
    public static int maxProfit2(int[] prices)
    {
        int len = prices.length;
        int max = 0, min = prices[0], sum = 0;

        for (int i = 1; i < len - 1; i++) {
            if (prices[i] > prices[i+1] && prices[i] > min) {
                max += prices[i] - min;
                min = prices[i + 1];
            } else {
                max = Math.max(max, prices[i] - min);
                min = Math.min(min, prices[i]);
            }

        }
        return max;
    }

    /*
    309. 最佳买卖股票时机含冷冻期

    给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     */
    public int maxProfit(int[] prices)
    {
        if (prices.length < 2) return 0;

        int len = prices.length;
        int f0 = -prices[0];
        int f1 = 0, f2 = 0;

        for (int i = 1; i < len; i++) {
            int newf0 = Math.max(f0,f2-prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1,f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }
        return Math.max(f1,f2);
    }

    /*
    70. 爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    f(n) = f(n-1) + f(n-2)
     */
    public int climbStairs(int n)
    {
        if (n <= 2) return n;
        int dp[] = new int[n];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*
        96. 不同的二叉搜索树
        给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     */
    public int numTrees(int n)
    {
        // 空树也是1种，所以占用0，当有n个数时，则有n+1棵树。
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    /**
     * 95. 不同的二叉搜索树 II
     * 输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     */
    public class TreeNode
    {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) {
              this.val = val;
          }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }
    public List<TreeNode> generateTrees(int n)
    {
        if (n < 1) return new LinkedList<TreeNode>();
        else return helper(1,n);

    }
    private List<TreeNode> helper(int start, int end)
    {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTrees = helper(start,i-1);
            List<TreeNode> subRightTrees = helper(i+1,end);

            for (TreeNode left :subLeftTrees) {
                for (TreeNode right : subRightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }

    /**
     * 面试题 17.13. 恢复空格
     * 同StringPratics.
     * 动态规划解法：
     * 1、状态定义：
     *      dp[i] 表示字符串的前 i 个字符的最少未匹配数。
     * 2、状态转移：
     *      假设当前我们已经考虑完了前 i 个字符了，对于前 i + 1 个字符对应的最少未匹配数：
     *      第 i + 1 个字符未匹配，则 dp[i + 1] = dp[i] + 1，即不匹配数加 1;
     *      遍历前 i 个字符，若以其中某一个下标 idx 为开头、以第 i + 1 个字符为结尾的字符串正好在词典里，则 dp[i] = min(dp[i], dp[idx]) 更新 dp[i]。
     */
    public int reSpace1(String[] dictionary, @NotNull String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }
        return dp[n];
    }

    public int reSpace2(String @NotNull [] dictionary, String sentence) {
        // 构建字典树
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.insert(word);
        }
        // 状态转移，dp[i] 表示字符串的前 i 个字符的最少未匹配数
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx: trie.search(sentence, i - 1)) {
                dp[i] = Math.min(dp[i], dp[idx]);
            }
        }
        return dp[n];
    }

    /**
     * 42. 接雨水
     * https://leetcode-cn.com/problems/trapping-rain-water/
     */
    public int trap(int[] height)
    {
        int len = height.length;
        int sum = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        for (int i = 1; i < len-1; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        for (int i = len-2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        for (int i = 1; i < len-1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }

    /**
     * 5. 最长回文串
     */
    public String longestPalindrome(String s)
    {
        if (s.length()<2) return s;

        char[] charArr = s.toCharArray();
        int len = charArr.length;
        int start = 0, maxLen = 1;

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i],false);
        }

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = j-1; i >= 0; i--) {
                if (charArr[i] == charArr[j]) {
                    if (j-i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    int curLen = j-i+1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start + maxLen);
    }

    /**
     * 440. 字典序的第K小数字
     *
     * 输入:
     * n: 13   k: 2
     *
     * 输出:
     * 10
     * 解释:
     * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
     */
    public int findKthNumber(int n, int k)
    {
        int cur = 1; //当前指针位置
        int prefix = 1; //当前前缀

        while (cur < k) {
            int count = getCount(n,prefix); //获得当前前缀下的所有子树

            if (cur + count > k) { //在当前前缀的子树下
                prefix *= 10;
                cur++;
            } else {
                prefix++;
                cur += count;
            }
        }
        return prefix;
    }
    /** 获得当前前缀下的所有子树 */
    private int getCount(int n, int prefix)
    {
        long cur = prefix; //当前前缀
        long next = prefix + 1; //下一个前缀
        int count = 0;

        while (cur < n) {
            count += Math.min(next,n+1) - cur;
            cur *= 10;
            next *= 10;
            // 1.假设 n=112， 当前 cur=1 ; next=2 ; count+=min(2,112+1)-1 = 1   ==> the reason of n+1 is we need add current root.
            // 2. after first loop, cur=10 < 112 ; next=20 ; count+=min(20,112+1)-10 = 10+1;
            // 3. final loop cus in this loop cur become 1000 > 112, cur=100 < 112 ; next=200; count+=min(200,112+1)-100 = 13+10+1;
            // return count = 24;
        }
        return count;
    }

/**
 *
 */

//    public static void main(String[] args) {
//        int i = 1, k = 3;
//        while (i<k){
//            System.out.println('a');
//            i++;
//        }
//    }
}

