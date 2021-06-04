package binarytree.middle;

import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package binarytree.middle
 * @desc 103. 二叉树的锯齿形层序遍历
 * @date 2021/6/4
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *   /     \
 * 15       7
 * 返回锯齿形层序遍历如下：
 *
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 通过次数143,349 提交次数251,000
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * BFS
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.61%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了80.49%的用户
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        int l = 1;
        while (!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode n = queue.poll();
                levelList.add(n.val);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            if (!((l & 1) == 1)){
                Collections.reverse(levelList);
            }
            list.add(levelList);
            l++;
        }
        return list;
    }
}
