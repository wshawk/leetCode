package leetcode.binarytree.easy;

import leetcode.binarytree.MultiTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.binarytree.easy
 * @desc 589. N 叉树的前序遍历
 * @date 2021/6/3
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 *
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 进阶：
 *
 * 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 *
 * 提示：
 *
 * N 叉树的高度小于或等于 1000
 * 节点总数在范围 [0,10^4] 内
 * 通过次数78,185提交次数105,201
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 */
public class NAryTreePreorderTraversal {
    /**
     * 递归解法
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.4 MB, 在所有 Java 提交中击败了99.87%的用户
     * @param root
     * @return
     */
    public List<Integer> preorderRecursion(MultiTreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderHelper(root, list);
        return list;
    }

    /**
     * 前序遍历
     * 根 -> 左 -> 右
     * @param root
     * @param list
     */
    private void preorderHelper(MultiTreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.children != null){
            for (int i=0,len=root.children.size(); i<len; i++){
                preorderHelper(root.children.get(i), list);
            }
        }
    }

    /**
     * 迭代解法
     * TODO: 待解决
     * @param root
     * @return
     */
    public List<Integer> preorderIteration(MultiTreeNode root) {
        List<Integer> list = new ArrayList<>();
        return list;
    }

    /**
     * 前序遍历 根 -> 左 -> 右
     * @param root
     * @return
     */
//    public List<Integer> preorder(MultiTreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        ans.add(root.val);
//        for ()
//    }
}
