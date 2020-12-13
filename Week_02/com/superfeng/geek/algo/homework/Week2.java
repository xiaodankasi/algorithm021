package com.superfeng.geek.algo.homework;

import java.util.*;

/**
 * Week2
 * 第二周作业题
 *
 * @author fc
 * @version 1.0
 * @date 2020/12/7 22:15
 */
public class Week2 {

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/">
     * <strong>94.二叉树的中序遍历</strong>
     * </a>
     *
     * @param root 二叉树根节点
     * @return 中序遍历结果
     */
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return result;
        }
        if (null != root.left) {
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if (null != root.right) {
            inorderTraversal(root.right);
        }
        return result;
    }

    /**
     * <a href="https://leetcode-cn.com/problems/top-k-frequent-elements/">
     * <strong>347.前K个高频元素
     * </strong>
     * </a>
     *
     * @param nums 入参数组
     * @param k    滑动窗口大小
     * @return 入参数组中前K个高频元素
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        int[] res = new int[k];
        int idx = 0;
        for (int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

