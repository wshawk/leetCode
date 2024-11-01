package leetcode.binarytree.easy;

import leetcode.binarytree.TreeNode;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @date 2021/1/20
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(3);
        TreeNode leftChild = new TreeNode(9);
        TreeNode rigthChild = new TreeNode(20);
        TreeNode rigthChildLeft = new TreeNode(15);
        TreeNode rigthChildRight = new TreeNode(7);

        rigthChild.setRight(rigthChildRight);
        rigthChild.setLeft(rigthChildLeft);

        rootNode.setLeft(leftChild);
        rootNode.setRight(rigthChild);


        System.out.println(getNodeDepth(rootNode));
    }
    // public static int maxDepth(TreeNode root) {
    //     return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }
    public static int maxDepth(TreeNode root) {
        int leftDepth = 0, rightDepth = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null){
            leftDepth++;
        }
        if (root.right != null){
            rightDepth++;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return getNodeDepth(root, leftDepth, rightDepth);
    }
    // 获取一个节点的深度
    // 错误案例
    @Deprecated
    public static int getNodeDepth(TreeNode root, int leftDepth, int rightDepth) {
        if (root == null) {
            return 0;
        }
        if (root.right != null) {
            rightDepth++;
            rightDepth = getNodeDepth(root.right, leftDepth, rightDepth);
        }
        if (root.left != null) {
            leftDepth++;
            leftDepth = getNodeDepth(root.left, leftDepth, rightDepth);
        }

        return Math.max(leftDepth, rightDepth);
    }

    /**
     * 正解
     * @param root
     * @return
     */
    public static int getNodeDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int leftDepth =  getNodeDepth(root.left);
        int rightDepth = getNodeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    //
    //
    // // 二叉树的后序遍历
    // public static void postOrder(TreeNode root){
    //     if (root != null){
    //         postOrder(root.left);
    //         postOrder(root.right);
    //         System.out.print(root.val + " ");
    //     }else{
    //         return;
    //     }
    // }
}

