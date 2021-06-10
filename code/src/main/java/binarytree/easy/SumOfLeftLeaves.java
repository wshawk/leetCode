package binarytree.easy;

import binarytree.TreeNode;

/**
 * @author hawk
 * @package binarytree.easy
 * @desc 404. 左叶子之和
 * @date 2021/6/10
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 * 通过次数83,820提交次数145,818
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 */
public class SumOfLeftLeaves {
    /**
     * 递归
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int leafsValue = 0;
        sumOfLeftLeavesRecursion(root, leafsValue);
        return leafsValue;
    }

    private void sumOfLeftLeavesRecursion(TreeNode root, int leafsValue) {
    }
}
