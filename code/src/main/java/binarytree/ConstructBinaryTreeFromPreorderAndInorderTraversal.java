package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wsHawk
 * @Title: ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @ProjectName code
 * @Description: 105. 从前序与中序遍历序列构造二叉树
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
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode t = buildTreeV1(preorder, inorder);
        System.out.println("==================");
    }
    /**
     * 前序遍历：根左右
     * 中序遍历：左根右
     * 执行用时：138 ms, 在所有 Java 提交中击败了5.27%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了8.72%的用户
     * 惨不忍睹。。。。
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTreeV1(int[] preorder, int[] inorder) {
        /*
            1. 前序遍历的第一个元素就是根节点
            2. 在中序遍历时，根节点的左边就是左子树，右边是右子树
            3. 再根据前序遍历的顺序还原该树
         */
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length < 3){
            if (preorder.length == 2){
                boolean flag = true;
                for (int i=0; i<preorder.length; i++){
                    if (preorder[i] != inorder[i]){
                        flag = false;
                    }
                }
                if (flag){
                    root.right = new TreeNode(preorder[1]);
                }else{
                    root.left = new TreeNode(preorder[1]);
                }
                return root;
            } else{
                return root;
            }
        }
        List<Integer> leftChildInOrder  = new ArrayList<>();
        List<Integer> rightChildInOrder  = new ArrayList<>();
        int rightIndex = 0;
        for (int i=0,len=inorder.length; i<len; i++){
            if (inorder[i] == preorder[0]){
                rightIndex = i;
                break;
            }else{
                leftChildInOrder.add(inorder[i]);
            }
        }
        for (int j=rightIndex+1; j<inorder.length; j++){
            rightChildInOrder.add(inorder[j]);
        }
        List<Integer> leftChildPreOrder = new ArrayList<>();
        List<Integer> rightChildPreOrder = new ArrayList<>();
        for (int i=1; i<=leftChildInOrder.size(); i++){
            leftChildPreOrder.add(preorder[i]);
        }
        for (int i=preorder.length - rightChildInOrder.size(); i<preorder.length; i++){
            rightChildPreOrder.add(preorder[i]);
        }
        int[] leftChildInOrderArr = new int[leftChildInOrder.size()];
        int[] rightChildInOrderArr = new int[rightChildInOrder.size()];
        int[] leftChildPreOrderArr = new int[leftChildPreOrder.size()];
        int[] rightChildPreOrderArr = new int[rightChildPreOrder.size()];
        for(int i = 0; i < leftChildInOrderArr.length; i ++){
            leftChildInOrderArr[i] = leftChildInOrder.get(i);
        }
        for(int i = 0; i < rightChildInOrderArr.length; i ++){
            rightChildInOrderArr[i] = rightChildInOrder.get(i);
        }
        for(int i = 0; i < leftChildPreOrderArr.length; i ++){
            leftChildPreOrderArr[i] = leftChildPreOrder.get(i);
        }
        for(int i = 0; i < rightChildPreOrderArr.length; i ++){
            rightChildPreOrderArr[i] = rightChildPreOrder.get(i);
        }
        root.left = buildTreeV1(leftChildPreOrderArr, leftChildInOrderArr);
        root.right = buildTreeV1(rightChildPreOrderArr, rightChildInOrderArr);
        return root;
    }

    public static TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        return null;
    }
}
