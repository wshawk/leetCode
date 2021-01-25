package binarytree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hawk
 * @package binarytree
 * @desc 二叉树的层序遍历
 * @date 2021/1/25
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode node = MergeTwoBinaryTrees.getTree1();
        levelOrder(node);
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
}
