package binarytree.easy;

import binarytree.TreeNode;
import binarytree.TreeNodeUtils;
import sun.util.resources.cldr.wae.LocaleNames_wae;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author hawk
 * @package binarytree
 * @desc 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个叶值序列 。
 *               3
 *            /     \
 *           5       1
 *          / \     / \
 *         6   2   9   8
 *            / \
 *           7   4
 * 举个例子，如上图所示，给定一棵叶值序列为(6, 7, 4, 9, 8)的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是叶相似的。
 *
 * 如果给定的两个头结点分别为root1 和root2的树是叶相似的，则返回true；否则返回 false 。
 *
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 *
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 *
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 *
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * 提示：
 *
 * 给定的两棵树可能会有1到 200个结点。
 * 给定的两棵树上的值介于 0 到 200 之间。
 *
 * @date 2021/1/27
 */
public class LeafSimilarTrees {
    public static void main(String[] args) {
        Integer[] nums = {3,5,1,6,2,9,8,null,null,7,4};
        TreeNode node = TreeNodeUtils.generateBinaryTree(nums);
        List<Integer> leafs = getLeaves(node);
        leafs.forEach(System.out::println);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = getLeaves(root1);
        List<Integer> root2Leaves = getLeaves(root2);
        if (root1Leaves.size() != root2Leaves.size()){
            return false;
        }
        for (int i=0, len=root1Leaves.size(); i<len; i++){
            if (!root1Leaves.get(i).equals(root2Leaves.get(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 获取一棵二叉树的所有叶子节点
     * @param root 二叉树
     */
    public static List<Integer> getLeaves(TreeNode root){
        List<Integer> leaves = new ArrayList<>();
        setLeaves(root,leaves);
       return leaves;
    }

    public static void setLeaves(TreeNode root, List<Integer> leaves){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            leaves.add(root.val);
        }
        setLeaves(root.left, leaves);
        setLeaves(root.right, leaves);
    }
}
