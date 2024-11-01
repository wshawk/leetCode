package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc 230. 二叉搜索树中第K小的元素
 * @date 2021/6/3
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第k个最小元素（从 1 开始计数）。
 *
 * 示例 1：
 *
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * 提示：
 *
 * 树中的节点数为 n 。
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
 *
 * 通过次数112,891提交次数153,581
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 */
public class KthSmallestElementInABst {
    /**
     * BFS
     * 执行用时：12 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了16.26%的用户
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestBFS(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        while (!queue.isEmpty()){
            TreeNode n = queue.poll();
            list.add(n.val);
            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
        }
        Collections.sort(list);
        return list.get(k - 1);
    }

    /**
     * 题目是二叉搜索树，
     * 即：右子节点的值 > 根节点的值 > 左子树节点的值
     * 中序遍历：左 -> 中 -> 右
     * 刚好是排好顺序的列表
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了48.83%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了24.72%的用户
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestMiddleOrder(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        middleOrder(root, list, k);
        return list.get(k - 1);
    }
    public void middleOrder(TreeNode root, List<Integer> list,  int k){
        if (root == null) return;
        if (list.size() == k) return;
        middleOrder(root.left, list, k);
        list.add(root.val);
        middleOrder(root.right, list, k);
    }
}
