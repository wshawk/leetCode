package binarytree;

import sun.reflect.generics.tree.Tree;

/**
 * @author hawk
 * @package binarytree
 * @desc
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 *  示例 1:
 *  输入:
 * Tree 1                     Tree 2
 *   1                         2
 *  / \                       / \
 * 3   2                     1   3
 * /                          \   \
 * 5                           4   7
 *
 * 输出:
 * 合并后的树:
 *         3
 *        / \
 *       4   5
 *      / \   \
 *     5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 * @date 2021/1/21
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        TreeNode tree1 = getTree1();
        TreeNode tree2 = getTree2();

        TreeNode mergeTree = mergeTrees(tree1, tree2);
        // 预期输出结果：3 4 5 4 5 7
        TreeNodeUtils.preOrder(mergeTree);
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null){
            return null;
        }
        if (t1 != null && t2 != null){
            t1 = new TreeNode(t1.val + t2.val, mergeTrees(t1.left, t2.left), mergeTrees(t1.right, t2.right));
        }
        if (t1 == null && t2 != null){
            t1 = t2;
        }
        return t1;
    }
/*
             Tree 1                     Tree 2
            *   1                         2
            *  / \                       / \
            * 3   2                     1   3
            * /                          \   \
            * 5                           4   7

 */
    private static TreeNode getTree2() {
        TreeNode root = new TreeNode(2);
        TreeNode leftChild = new TreeNode(1);
        TreeNode leftChildChild = new TreeNode(4);
        TreeNode rightChild = new TreeNode(3);
        TreeNode rightChildChild = new TreeNode(7);

        leftChild.setRight(leftChildChild);
        rightChild.setRight(rightChildChild);

        root.setLeft(leftChild);
        root.setRight(rightChild);
        return root;
    }

    private static TreeNode getTree1() {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(3);
        TreeNode leftChildChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(2);

        leftChild.setLeft(leftChildChild);

        root.setLeft(leftChild);
        root.setRight(rightChild);
        return root;
    }

}

