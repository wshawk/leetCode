package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树: root =[3,5,1,6,2,0,8,null,null,7,4]
 *          3
 *        /   \
 *       5     1
 *      / \   / \
 *     6   2  0  8
 *        / \
 *       7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * @date 2021/1/22
 */
public class TheNearestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        /*
             Tree 1                     Tree 2
            *   1                         2
            *  / \                       / \
            * 3   2                     1   3
            * /                          \   \
            * 5                           4   7

 */
        TreeNode node = MergeTwoBinaryTrees.getTree1();

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(3);

        System.out.println(lowestCommonAncestor(node, p, q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        初步思路：
            1. 确定p、q在root中的位置
            2. 向上遍历
            3. 找到相同的节点，返回该节点
        优化想法：
            1. 遍历root的节点，存到节点数组中，每一个元素都是一棵树
            2. 找到p、q节点在数组中的位置i、j
            3. 以索引比较小的那个截断
            4. 向前遍历即可
         */
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        int pIndex = list.stream().filter(x->x.val==p.val).mapToInt(y -> list.indexOf(y)).sum();
        int qIndex = list.stream().filter(x->x.val==q.val).mapToInt(y -> list.indexOf(y)).sum();
        int index = Math.min(pIndex, qIndex);
        // 向前遍历每一棵树
        // 有p、q节点值的那棵树就是要返回的树
        TreeNode result = null;
        for (int i=index; i > -1; i--){
            if (containsNode(list.get(i),p,q)){
                result = list.get(i);
                break;
            }
        }
        return result;
    }

    private static boolean containsNode(TreeNode treeNode, TreeNode p, TreeNode q) {
        if (q == null || p == null){
            return false;
        }
        return containsNode(treeNode, p) && containsNode(treeNode, q);
    }

    private static boolean containsNode(TreeNode treeNode, TreeNode p){
        if (treeNode == null){
            return false;
        }

        return treeNode.val==p.val || containsNode(treeNode.left, p) || containsNode(treeNode.right, p);
    }

    public static void preorder(TreeNode node, List<TreeNode> list){
        if (node == null){
            return ;
        }
        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }
}
