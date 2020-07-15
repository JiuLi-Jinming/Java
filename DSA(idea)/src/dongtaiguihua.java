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
        96. 不同的二叉搜索树

        给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     */
    public int numTrees(int n) {

    }



//    public static void main(String[] args) {
//        int[] a = {7,1,5,3,6,4};
//
//        int b = maxProfits(a);
//        System.out.println(b);
//    }
}

