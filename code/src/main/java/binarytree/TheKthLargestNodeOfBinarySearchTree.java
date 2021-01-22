package binarytree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hawk
 * @package binarytree
 * @desc 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *   2
 * 输出: 4
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 限制：
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * @date 2021/1/22
 */
public class TheKthLargestNodeOfBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftChild = new TreeNode(3);
        TreeNode leftChildChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(2);

        leftChild.setLeft(leftChildChild);

        root.setLeft(leftChild);
        root.setRight(rightChild);
        // System.out.println(kthLargest_first(root, 1));
    }

    public static int kthLargest_second(TreeNode root, int k) {

        return 0;
    }

    /**
     * 第一版...
     * @param root
     * @param k
     * @return
     */
    public static int kthLargest_first(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        preOrder(root,set);
        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        Collections.reverse(list);
        return list.get(k - 1);
    }

    public static void preOrder(TreeNode root, Set<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}
