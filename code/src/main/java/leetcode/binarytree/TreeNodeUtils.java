package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree
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

    /**
     * 根据数组生成一棵二叉树
     *
     * 输入示例：
     * root -> [1,2,3,null,null,5,8]
     *
     * 输出结果：
     *        1
     *       / \
     *      2   3
     *         / \
     *        5   8
     * @param array 数组
     * @return
     */
    public static TreeNode generateBinaryTree(Integer[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int len = nums.length;
        int index = 0;
        TreeNode root = new TreeNode(nums[index]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode cur;
        while (index < len) {
            index++;
            if (index >= len) return root;
            cur = nodeQueue.poll();
            Integer left = nums[index];
            if (left != null) {
                cur.left = new TreeNode(left);
                nodeQueue.offer(cur.left);
            }

            index++;
            if (index >= len) return root;
            Integer right = nums[index];
            if (right != null) {
                cur.right = new TreeNode(right);
                nodeQueue.offer(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] test =  {1,2,3,null,null,5,8};
        TreeNode node = generateBinaryTree(test);
        System.out.println("===========");
    }
}
