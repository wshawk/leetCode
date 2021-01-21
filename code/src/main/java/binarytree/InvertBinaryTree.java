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
        TreeNodeUtils.preOrder(node);

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

    // 二叉树的翻转-官方题解
    public TreeNode invertTree_leetcode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
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
}
