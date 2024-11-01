package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;
import leetcode.binarytree.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.easy
 * @desc 111. 二叉树的最小深度
 * @date 2021/6/10
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * 通过次数226,938提交次数474,309
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5};
        TreeNode root = TreeNodeUtils.generateBinaryTree(nums);
        System.out.println(minDepth(root));
    }
    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.89%的用户
     * 内存消耗：58 MB, 在所有 Java 提交中击败了87.18%的用户
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        int minDepth = 1;
        while (!queue.isEmpty()){
           for (int i = 0,len=queue.size(); i<len; i++){
               TreeNode node = queue.poll();
               if (node.left == null && node.right == null){
                   return minDepth;
               }
               if (node.left != null){
                   queue.offer(node.left);
               }
               if (node.right != null){
                   queue.offer(node.right);
               }
           }
            minDepth++;
        }
        return minDepth;
    }
}
