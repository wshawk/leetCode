package binarytree.easy;

import binarytree.TreeNode;
import binarytree.TreeNodeUtils;

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
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeNodeUtils.generateBinaryTree(nums);
        System.out.println(sumOfLeftLeavesRecursion(root));
    }


    /**
     * 输出二叉树的左叶子节点
     * @param root
     */
    public static void leftLeaves(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null){
            System.out.println("left leaf: " + root.left.val);
        }
        leftLeaves(root.left);
        leftLeaves(root.right);
    }
    /**
     * 递归
     * @param root
     * @return
     */
    public static int sumOfLeftLeavesRecursion(TreeNode root) {
        int leafValue = 0;
        if (root == null) {
            return leafValue;
        }
        if (root.left != null && root.left.left == null && root.left.right == null){
                leafValue+=root.left.val;
        }
        return leafValue + sumOfLeftLeavesRecursion(root.left) + sumOfLeftLeavesRecursion(root.right);
    }
}
