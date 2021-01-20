package binarytree;

import javax.swing.tree.TreeNode;

/**
 * @author hawk
 * @package binarytree
 * @desc
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @date 2021/1/19 ---通过日期：2021-01-20 12：00：00
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree temp = new InvertBinaryTree();
        // 预期输出结果：4 2 1 3 7 6 9
        // 实际输出结果：4 2 1 3 7 6 9
        // preOrder(temp.getTree());

        // 预期输出结果：1 2 3 4 6 7 9
        // 实际输出结果：1 2 3 4 6 7 9
        // middleOrder(temp.getTree());

        // 预期输出结果：1 3 2 6 9 7 4
        // 实际输出结果：1 3 2 6 9 7 4
        // postOrder(temp.getTree());

        TreeNode node = temp.invertTree(temp.getTree());
        preOrder(node);

    }
    public TreeNode getTree(){
        TreeNode leftChildChildLeft = new TreeNode(1);
        TreeNode leftChildChildRight = new TreeNode(3);
        TreeNode leftChild = new TreeNode(2, leftChildChildLeft, leftChildChildRight);

        TreeNode rightChildChildLeft = new TreeNode(6);
        TreeNode rightChildChildRight = new TreeNode(9);
        TreeNode rightChild = new TreeNode(7, rightChildChildLeft, rightChildChildRight);

        return new TreeNode(4, leftChild, rightChild);
    }

    // 二叉树的前序遍历
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }else{
            return;
        }
    }

    // 二叉树的中序遍历
    public static void middleOrder(TreeNode root){
        if (root != null){
            middleOrder(root.left);
            System.out.print(root.val + " ");
            middleOrder(root.right);
        }else{
            return;
        }
    }

    // 二叉树的后序遍历
    public static void postOrder(TreeNode root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }else{
            return;
        }
    }
    // 二叉树的翻转
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
          invertPreOreder(root);
          return root;
        }else{
            return null;
        }
    }

    private void invertPreOreder(TreeNode root) {
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertPreOreder(root.left);
            invertPreOreder(root.right);
        }else{
            return ;
        }
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        TreeNode(){}
        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
