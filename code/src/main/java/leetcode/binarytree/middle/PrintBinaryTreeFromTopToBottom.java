package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc 剑指 Offer 32 - I. 从上到下打印二叉树
 * @date 2021/6/2
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 通过次数99,937提交次数154,480
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 */
public class PrintBinaryTreeFromTopToBottom {
    /**
     * 执行用时：6ms
     * 内存消耗：38.7MB
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                if (node != null){
                    res.add(node.val);
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 执行用时：1ms
     * 内存消耗：38.6MB
     * @param root
     * @return
     */
    public int[] levelOrderUpdate(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            offer(root);
        }};
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0, len = res.size(); i < len; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
