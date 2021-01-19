package binarytree;

/**
 * @author hawk
 * @package binarytree
 * @desc
 * @date 2021/1/19
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return null;
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
    }
}
