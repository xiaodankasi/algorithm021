package com.superfeng.geek.algo.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Week3
 * 第三周作业题
 *
 * @author fc
 * @version 1.0
 * @date 2020/12/15 0:25
 */
public class Week3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">
     * <strong>
     * 236. 二叉树的公共祖先
     * </strong>
     * </a>
     *
     * @param root 二叉树根节点
     * @param p    待寻找公共祖先的节点1
     * @param q    待寻找公共祖先的节点2
     * @return p q 的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1.审题
        // 最近公共祖先：设节点 root 为节点 p, q 的某公共祖先，
        // 若其左子节点 root.left 和
        // 右子节点 root.right 都不是 p,q 的公共祖先，
        // 则称 root 是 “最近的公共祖先”
        // 二叉树中节点都唯一保证了返参结果唯一
        // 入参的两个节点 p,q不相同且均存在于给定的二叉树 保证了无需校验节点是否存在
        // 2. possible answer
        // 无思路
        //
        if (root == null || root == p || root == q) {
            return root;
        }
        // 树的后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    /**
     * 77.组合
     *
     * @param n 整数范围
     * @param k 组合数的大小
     * @return k个数的所有组合集
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }
}
