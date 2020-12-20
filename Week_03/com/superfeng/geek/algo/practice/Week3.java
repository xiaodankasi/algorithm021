package com.superfeng.geek.algo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Week3
 * T第三周练习题
 *
 * @author fc
 * @version 1.0
 * @date 2020/12/15 0:25
 */
public class Week3 {

    /**
     * 爬楼梯
     *
     * @param n 要爬的楼梯数
     * @return 方法
     */
    public static int climbStairs(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private List<String> result;

    /**
     * 括号生成
     *
     * @param n 括号对
     * @return 符合条件的括号对
     */
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {

        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (right < left) {
            generate(left, right + 1, n, s + ")");
        }
    }

    public static void main(String[] args) {
        Week3 week3 = new Week3();
        week3.generateParenthesis(3);
    }
}
