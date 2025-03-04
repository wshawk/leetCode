package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.binarytree.easy
 * @desc
 * @date 2025/1/14
 */
public class ForeachTree {
    /**
     * 返回中序遍历的结果
     *
     * 中序遍历： 左 -> 根 -> 右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        return ans;
    }

    /**
     * 使用迭代的方式进行遍历
     */
    public List<Integer> inorderTraversalByIterator(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        
        return ans;
    }
}
