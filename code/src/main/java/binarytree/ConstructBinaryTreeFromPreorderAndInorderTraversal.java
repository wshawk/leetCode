package binarytree;

/**
 * @author wsHawk
 * @Title: ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @ProjectName code
 * @Description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *                   3
 *                 /  \
 *               9     20
 *                    /  \
 *                   15   7
 * @since 2021/2/1 11:36
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /**
     * 前序遍历：根左右
     * 中序遍历：左根右
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*
            1. 前序遍历的第一个元素就是根节点
            2. 在中序遍历时，根节点的左边就是左子树，右边是右子树
            3. 再根据前序遍历的顺序还原该树
         */
        TreeNode root = new TreeNode(preorder[0]);
        int leftChildLength = 0;
        int rightChildLength = 0;
        for (int i=0,len=inorder.length; i<len-1; i++){
            if (inorder[i] == preorder[0]){
                leftChildLength = i;
                rightChildLength = len-i+1;
            }
        }
        int[] leftChild = new int[leftChildLength];
        int[] rightChild = new int[rightChildLength];
        return null;
    }
}
