package binarytree.middle;

import binarytree.TreeNode;
import binarytree.TreeNodeUtils;

/**
 * @author hawk
 * @package binarytree.middle
 * @desc 814. 二叉树剪枝
 * 给定二叉树根结点root，此外树的每个结点的值要么是 0，要么是 1。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 * <p>
 * 说明:
 * <p>
 * 给定的二叉树最多有 100 个节点。
 * 每个节点的值只会为 0 或 1 。
 * <p>
 * 通过次数20,038提交次数28,571
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-pruning
 * @date 2021/6/2
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
