package binarytree;

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
