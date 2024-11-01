package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc 二叉树的前序遍历
 * @date 2021/5/14
 */
public class BinaryTreePreorderTraversal {

    /**
     * 递归
     *
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.3 MB, 在所有 Java 提交中击败了99.05%的用户
     *
     * @param root 需要进行遍历的二叉树
     * @return 前序遍历的结果
     */
    public static List<Integer> recursionResolve(TreeNode root){
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }
    public static void recursion(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left == null && root.right == null){
            return;
        }
        if (root.left != null){
            recursion(root.left, result);
        }
        if (root.right != null){
            recursion(root.right, result);
        }
    }


    /**
     * 迭代
     *
     * 执行用时：1 ms, 在所有 Java 提交中击败了49.23%的用户
     * 内存消耗：36.2 MB, 在所有 Java 提交中击败了99.70%的用户
     *
     * @param root 需要进行遍历的二叉树
     * @return 前序遍历的结果
     */
    public List<Integer> iterationResolve(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                result.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return result;
    }
}
