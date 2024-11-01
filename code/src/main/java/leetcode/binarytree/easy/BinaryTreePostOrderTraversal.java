package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hawk
 * @package leetcode.binarytree.easy
 * @desc 145. 二叉树的后序遍历
 * @date 2021/6/3
 * 给定一个二叉树，返回它的 后序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 */
public class BinaryTreePostOrderTraversal {
    /**
     * 递归解法
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.8 MB, 在所有 Java 提交中击败了27.42%的用户
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        postOrder(root, r);
        return r;
    }
    private void postOrder(TreeNode root, List<Integer> r) {
        if (root == null) return;
        postOrder(root.left, r);
        postOrder(root.right, r);
        r.add(root.val);
    }

    /**
     * 迭代解法
     * TODO: 待解决
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>(){{push(root);}};
        while (!stack.isEmpty()){
            TreeNode n = stack.pop();
            stack.push(n);
            if (n.left != null){
                stack.push(n.left);
            }
            if (n.right != null){

            }
        }
        return null;
    }

}
