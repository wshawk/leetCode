package leetcode.binarytree.easy;

import leetcode.binarytree.MultiTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.binarytree
 * @desc 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个3叉树:
 *              1
 *            / | \
 *           3  2  4
 *          / \
 *         5   6
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * 说明:递归法很简单，你可以使用迭代法完成此题吗?
 *
 * @date 2021/2/19
 */
public class NAryTreePostOrderTraversal {
    /**
     * 后续遍历：左右根
     * 递归解法
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了86.50%的用户
     * @param root
     * @return
     */
    public List<Integer> postorder(MultiTreeNode root) {
        List<Integer> list = new ArrayList<>();
        cycle(root, list);
        return list;
    }
    private void cycle(MultiTreeNode root, List<Integer> list){
        if (root != null){
            if (root.children != null && root.children.size() > 0){
                for (int i=0, len=root.children.size(); i<len; i++){
                    cycle(root.children.get(i), list);
                }
            }
            list.add(root.val);
        }
    }


    /**
     * 迭代解法
     * -----暂时没什么思路，，，，
     * @param root
     * @return
     */
    public List<Integer> postorderIterator(MultiTreeNode root) {
        List<Integer> list = new ArrayList<>();
        return list;
    }
}
