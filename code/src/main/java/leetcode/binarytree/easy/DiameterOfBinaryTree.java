package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。
 *
 *
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * @date 2021/1/26
 */
public class DiameterOfBinaryTree {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        getDepth(root);
        return diameter;
    }

    private int getDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if ( diameter < left + right){
            diameter = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
