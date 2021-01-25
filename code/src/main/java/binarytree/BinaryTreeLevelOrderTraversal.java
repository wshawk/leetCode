package binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package binarytree
 * @desc 二叉树的层序遍历
 * @date 2021/1/25
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = MergeTwoBinaryTrees.getTree1();
        levelOrderLeetCode(node);
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<List<Integer>> result = new ArrayList<>();
        listTree(list, result);
        return result;
    }
    public static void listTree(List<TreeNode> list, List<List<Integer>> result){
        List<TreeNode> next = new ArrayList<>();
        List<Integer> levels = new ArrayList<>();
        list.forEach(x -> {
            if (x != null){
                System.out.print(x.val+" ");
                levels.add(x.val);
                if (x.left != null){
                    next.add(x.left);
                }
                if (x.right != null){
                    next.add(x.right);
                }
            }
        });
        if (levels.size() > 0){
            System.out.println(" ");
            result.add(levels);
        }
        if (next.size() > 0){
            listTree(next, result);
        }
    }

    /**
     * 官方题解
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderLeetCode(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
