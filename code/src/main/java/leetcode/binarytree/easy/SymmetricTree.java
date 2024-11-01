package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @date 2021/1/22
 */
public class SymmetricTree {
    public static void main(String[] args) {

    }

    // 核心思路
    // 1. 比较根节点下的左右孩子节点的值是否相同
    // 2. 比较以左右孩子节点为根节点的孩子节点的 左右和右左节点的值是否相同
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    // 递归解法
    public static boolean check(TreeNode left, TreeNode right){
       if (left == null && right == null){
           return true;
       }
       if (left == null || right == null){
           return false;
       }
       return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}
