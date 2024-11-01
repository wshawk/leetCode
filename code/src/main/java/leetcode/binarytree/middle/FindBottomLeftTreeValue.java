package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc 513. 找树左下角的值
 * @date 2021/6/3
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 通过次数38,755提交次数53,140
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 */
public class FindBottomLeftTreeValue {
    /**
     * BFS
     * 执行用时：2 ms, 在所有 Java 提交中击败了65.72%的用户
     * 内存消耗：37.6 MB, 在所有 Java 提交中击败了99.51%的用户
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        while (!q.isEmpty()){
            int left = 0;
            for (int i=0,len=q.size(); i<len; i++){
                TreeNode n = q.poll();
                if (i == 0) left = n.val;
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            if (q.isEmpty()){
                return left;
            }
        }
        throw null;
    }
}
