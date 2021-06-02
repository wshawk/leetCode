package binarytree.easy;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package binarytree
 * @desc 257. 二叉树的所有路径
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * @date 2021/5/29
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(5);

        root.left = left;
        root.right = new TreeNode(3);

        // binaryTreePaths(root).forEach(System.out::println);
        binaryTreePaths1(root);
    }
    /**
     * 返回二叉树的所有路径
     * 思路：前序遍历
     * 中 -> 左 -> 右
     * @param root 二叉树
     * @return 所有路径
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<String> left = new ArrayList<>();
        if (root.left != null){
            left = binaryTreePaths(root.left);
        }
        List<String> right = new ArrayList<>();
        if (root.right != null){
            right = binaryTreePaths(root.right);
        }
        if (root.left != null){
            res.add(root.val + "->" +root.left.val);
        }
        if (root.right != null){
            res.add(root.val + "->" +root.right.val);
        }
        res.addAll(left);
        res.addAll(right);
        return res;
    }
    // TODO: 记得再次尝试~
    public static void binaryTreePaths1(TreeNode root) {
       if (root == null) return;

    }
    public static void getString(TreeNode node, String initStr){
        if (node != null){
            initStr = "->" + node.val;
        }
    }
}
