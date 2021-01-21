package binarytree;

/**
 * @author hawk
 * @package binarytree
 * @desc
 * @date 2021/1/21
 */
public class TreeNodeUtils {
    /**
     * 二叉树的前序遍历
     * @param root
     */
    public static void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }else{
            return;
        }
    }

    /**
     * 二叉树的中序遍历
     * @param root
     */
    public static void middleOrder(TreeNode root){
        if (root != null){
            middleOrder(root.left);
            System.out.print(root.val + " ");
            middleOrder(root.right);
        }else{
            return;
        }
    }

    /**
     * 二叉树的后序遍历
     * @param root
     */
    public static void postOrder(TreeNode root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }else{
            return;
        }
    }

    /**
     * 获取二叉树的最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
