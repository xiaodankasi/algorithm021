package com.superfeng.geek.algo;

import java.util.Arrays;

/**
 * Week1 练习
 *
 * @author fengchao
 * @version 1.0
 * @date 2020/12/1 22:37
 */
public class Week1 {

    /**
     * 66. 加一<br/>
     * https://leetcode-cn.com/problems/plus-one/
     * <p>
     * 注：因long,int都会出现整数越界，因此通过将数组转换成整数后+1再取余做除转换成数组会出问题
     *
     * @param digits 入参数组
     * @return 数组最后一位加1后结果
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 283. 移动零<br/>
     * https://leetcode-cn.com/problems/move-zeroes/
     *
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {
        // 将非零的数通过index往前挪，最后对于index后的数全部置为0
        /*int m = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[m++] = nums[i];
            }
        }
        while (m < nums.length) {
            nums[m++] = 0;
        }*/
        // 计数器计数0的个数
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter++;
            } else if (counter != 0) {
                nums[i - counter] = nums[i];
                nums[i] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 125 验证回文串 <br/>
     * https://leetcode-cn.com/problems/valid-palindrome/
     * <br/>
     * <p>
     * 1.运用双指针双向比较<br/>
     * 2.直接利用API 筛选-反转-对比
     * </p>
     *
     * @param s 待判断是否为回文的字符串
     * @return 是否为回文串
     */
    public static boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }
        // 双指针解法
        /*int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            // 头部指针不超过尾部指针且头部指针不是字符或数字时跳过
            while (head < tail && !Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            }
            // 尾部指针不重合头部指针尾部指针不是字符或数字时跳过
            while (tail > head && !Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                return false;
            }
            head++;
            tail--;
        }*/
        //return true;
        String filterS = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverseS = new StringBuilder(filterS).reverse().toString();
        return filterS.equals(reverseS);
    }

    /**
     * <a href = "https://leetcode-cn.com/problems/climbing-stairs/">70.爬楼梯</a>
     * <br/>
     * <p>
     * 1.通项公式 {@code dp[n]=dp[n-1]+dp[n-2]} <br/>
     * </p>
     *
     * @param n 楼梯节数
     * @return 爬楼梯的总方法
     */
    public static int climbStairs(int n) {
        // 方法一： 动态规划 循环滚动
        /*int first = 0;
        int next = 0;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            first = next;
            next = result;
            result = first + next;
        }
        return result;*/

        // 方法二 动态规划
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        // 方法三：递归调用 此方法性能差，无法AC
        /*int step0 = 1;
        int step1 = 1;
        int step2 = 2;
        if (n == 1 || n == 0) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }*/
    }

    /**
     * <a herf="https://leetcode-cn.com/problems/container-with-most-water/">11.盛最多水的容器</a>
     *
     * @param height 入参数组
     * @return 最大面积
     */
    public static int maxArea(int[] height) {
        // 方法1：暴力破解法-----枚举
        // 时间复杂度 O(n^2),空间复杂度O(1)
        /*int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempArea = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(tempArea, maxArea);
            }
        }
        return maxArea;*/
        // 夹逼法 宽度固定的情况下两边向中间归拢
        // 时间复杂度O(n)
        int maxArea = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            int tempArea = (j - i + 1) * minHeight;
            maxArea = Math.max(tempArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // plusOne
        //int[] digits = {1, 2, 3};
        //System.out.println(Arrays.toString(plusOne(digits)));
        //System.out.println(Arrays.toString(plusOne(new int[] {4, 3, 2, 1})));
        //System.out.println(Arrays.toString(plusOne(new int[] {0})));
        //System.out.println(Arrays.toString(plusOne(new int[] {9})));
        //System.out.println(Arrays.toString(plusOne(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        //System.out.println(Arrays.toString(plusOne(new int[] {9, 9, 9, 9})));
        /*moveZeroes(new int[] {1, 0, 2});
        moveZeroes(new int[] {0, 1, 0, 3, 12});
        moveZeroes(new int[] {});*/

        /*System.out.println(climbStairs(0));
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(5));*/
        System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }
}
