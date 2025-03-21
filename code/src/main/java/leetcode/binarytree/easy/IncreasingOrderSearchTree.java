package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;
import leetcode.binarytree.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *            \
 *             7
 *              \
 *               8
 *                \
 *                 9
 *
 *
 * 提示：
 *
 * 给定树中的结点数介于 1 和100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * @date 2021/1/28
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        TreeNode test = TreeNodeUtils.generateBinaryTree(new Integer[] {5,3,6,2,4,null,8,1,null,null,null,7,9});
        increasingBST(test);
    }
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<Integer> queue = new LinkedList<>();
        middleOrder(root, queue);
        TreeNode head = new TreeNode(queue.poll());
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(head);
        while (!queue.isEmpty()){
            TreeNode rightChild = new TreeNode(queue.poll());
            if (!nodes.isEmpty()){
                TreeNode parent = nodes.poll();
                parent.right = rightChild;
                nodes.offer(parent.right);
            }
        }

        return head;
    }

    public static void middleOrder(TreeNode root, Queue<Integer> queue){
        if (root == null){
            return;
        }
        middleOrder(root.left, queue);
        queue.offer(root.val);
        middleOrder(root.right, queue);
    }
}
