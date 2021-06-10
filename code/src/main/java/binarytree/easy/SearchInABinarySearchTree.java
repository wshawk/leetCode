package binarytree.easy;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hawk
 * @package binarytree.easy
 * @desc 700. 二叉搜索树中的搜索
 * @date 2021/6/10
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 通过次数63,097提交次数83,429
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 */
public class SearchInABinarySearchTree {
    /**
     * BFS
     *
     * 未利用搜索二叉树的特性
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了7.34%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了5.01%的用户
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTBFS(TreeNode root, int val) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        while (!queue.isEmpty()){
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode n = queue.poll();
                if (n.val == val){
                    return n;
                }
                if (n.left != null){
                    queue.offer(n.left);
                }
                if (n.right != null){
                    queue.offer(n.right);
                }
            }
        }
        return null;
    }

    /**
     *
     * 递归
     *
     * 利用搜索二叉树的特性  左节点值 < 根节点值 < 右节点值
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.3 MB, 在所有 Java 提交中击败了51.11%的用户
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ?  searchBST(root.left, val) : searchBST(root.right, val);
    }
}
