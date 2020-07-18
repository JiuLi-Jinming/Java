package string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StringPratics
{
/*
    面试题 17.13.
    哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。
    在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。

    注意：本题相对原题稍作改动，只需返回未识别的字符数

    示例：
        输入：
            dictionary = ["looked","just","like","her","brother"]
            sentence = "jesslookedjustliketimherbrother"
        输出： 7
        解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符
。
 */
    public int respace(String[] dictionary, String sentence)
    {
        int len = sentence.length();
        int dp[] = new int[len + 1];
        dp[0] = 0;

        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i-1]+1;
            for (String word : dictionary) {
                if (sentence.substring(i - word.length(), i) == word) {
                    dp[i] = Math.min(dp[i], dp[i - word.length()]);
                }
            }
        }
        return dp[len];
    }

    /**
     * 8. 字符串转换整数 (atoi)
     * https://leetcode-cn.com/problems/string-to-integer-atoi/
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str)
    {
        int len = str.length();
        if (len < 1) return 0;
        int res = 0, start = 0, end = 0, index = 0;
        boolean negative = false;
        char[] chars = str.toCharArray();

        while (chars[index] == ' ' && index < len) {
            index++;
            if (index == str.length()) return 0;
        }

        if (chars[index] == '+' && index < len) {
            index++;
        } else if (chars[index] == '-' && index < len) {
            index++;
            negative = true;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }

        while (index < len && Character.isDigit(chars[index])) {
            int digit = chars[index] - '0';
            if (res > (Integer.MAX_VALUE-digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res*10 + digit;
            index++;
        }
        return negative ? (~res+1) : res;
    }


//    public static void main(String[] args) {
//        String a = "123";
//        System.out.println(a);
//        System.out.println(myAtoi(a));
//    }
}
