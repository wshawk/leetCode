package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc 515. 在每个树行中找最大值
 * @date 2021/6/3
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 * 通过次数30,335提交次数47,406
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> l = new ArrayList<>(levelSize);
            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                l.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            r.add(Collections.max(l));
        }
        return r;
    }

    public List<Integer> largestValuesMayBeBetter(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            offer(root);
        }};
        int lineMax = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                lineMax = Math.max(lineMax, node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            r.add(lineMax);
            lineMax = Integer.MIN_VALUE;
        }
        return r;
    }
}
