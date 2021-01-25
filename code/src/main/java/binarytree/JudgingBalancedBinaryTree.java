package binarytree;

/**
 * @author hawk
 * @package binarytree
 * @desc 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * @date 2021/1/25
 */
public class JudgingBalancedBinaryTree {

    /**
     * 从上到下的遍历，判断是否是平衡的
     * @param root
     * @return
     */
    public  boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(getDepth(root.left)
                - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public  int getDepth(TreeNode root){
        return root == null ? 0 : Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
