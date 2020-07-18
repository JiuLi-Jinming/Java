import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class tanxingsuanfa
{
    /**
     * 455. 分发饼干
     *
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
     * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     *
     * @param g 每个孩子的胃口
     * @param s 拥有饼干的size
     * @return
     */
    public int findContentChildren(int[] g, int[] s)
    {
        if (g == null || s == null) return 0;
        int gi = 0, si = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (gi < g.length || si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    /**
     * 55. 跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个位置。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums)
    {
        if (nums.length < 2) return true;
        int traget = nums.length - 1;

        for (int i = nums.length-2; i >= 0; i--) {
            if (traget - i <= nums[i]) {
                traget = i;
            }
        }
        return traget == 0;
    }

    /**
     * 406. 根据身高重建队列
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
     * 编写一个算法来重建这个队列。
     *
     * 注意：
     * 总人数少于1100人。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people)
    {
        if (people.length < 1 ||people[0].length < 1) return new int[0][0] ;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });

        List<int[]> res = new ArrayList<>();
        for (int[] i : people) {
            res.add(i[1],i);
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * 135. 分发糖果
     * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
     *
     * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
     *      每个孩子至少分配到 1 个糖果。
     *      相邻的孩子中，评分高的孩子必须获得更多的糖果。
     *      那么这样下来，老师至少需要准备多少颗糖果呢
     *
     * 链接：https://leetcode-cn.com/problems/candy
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings)
    {
        int len = ratings.length;
        if (len < 2) return len;
        /** 总数 */
        int sum = 0;
        /** 在当前i位置几颗糖 */
        int[] candies = new int[len];
        /** 每个位置最少1颗糖 */
        Arrays.fill(candies,1);
        /** 从左向右遍历，只检测左边位置如果低于当前位置，当前位置+1🍬 */
        for (int i = 1; i < len; i++) {
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        sum = candies[len-1];
        /** 从右向左遍历，同时得出sum，只检测右侧位置如果低于当前， 则当前位置max([i],[i+1]+1）检测如果之前是2当前也是2则不变 */
        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i],candies[i+1] + 1);
            }
            sum += candies[i];
        }

        return sum;
    }


}
