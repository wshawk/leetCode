package binarytree;

/**
 * @author hawk
 * @package binarytree
 * @desc
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * 提示：
 *
 * 1. 给定树的节点数范围是 [1, 100]。
 * 2. 每个节点的值都是整数，范围为 [0, 99] 。
 * @date 2021/1/21
 */
public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode child = new TreeNode(2);

        root.left = child;

        // System.out.println(isUnivalTree_first(root));
    }


    public static boolean isUnivalTree_leetcode(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree_leetcode(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree_leetcode(root.right)));
        return left_correct && right_correct;
    }

    /**
     * 第一版
     * @param root
     * @return
     */
    public static boolean isUnivalTree_first(TreeNode root) {
        if (root == null){
            return true;
        }
        if (root.left != null && root.right == null){
            return root.val == root.left.val && isUnivalTree_first(root.left);
        }
        if (root.right != null && root.left == null){
            return root.val == root.right.val && isUnivalTree_first(root.right);
        }
        if (root.right == null && root.left == null){
            return true;
        }
        return root.val == root.right.val
                && root.val == root.left.val
                && isUnivalTree_first(root.right)
                && isUnivalTree_first(root.left);
    }
}
