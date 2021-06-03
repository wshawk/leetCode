package binarytree.easy;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package binarytree.easy
 * @desc 637. 二叉树的层平均值
 * @date 2021/6/3
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 */
public class AverageOfLevelsInBinaryTree {
    /**
     * 执行用时：14 ms, 在所有 Java 提交中击败了8.45%的用户
     * 内存消耗：40.09 MB, 在所有 Java 提交中击败了6.58%的用户
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> r = new ArrayList<>();
        if (root == null) return r;

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{offer(root);}};
        while (!queue.isEmpty()){
            List<Integer> l = new ArrayList<>();
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode n = queue.poll();
                l.add(n.val);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            r.add(l.stream().mapToDouble(Number::doubleValue).summaryStatistics().getAverage());
        }
        return r;
    }

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了18.91%的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了59.99%的用户
     * @param root
     * @return
     */
    public List<Double> averageOfLevelsMayBeBetter(TreeNode root){
        List<Double> r = new ArrayList<>();
        if (root == null) return r;

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{offer(root);}};
        while (!queue.isEmpty()){
            Double sum = 0d;
            int len = queue.size();
            for (int i=0; i<len; i++){
                TreeNode n = queue.poll();
                sum += n.val;
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            r.add(sum/len);
        }
        return r;
    }

    /**
     * leetCode官方题解
     * 执行用时：3 ms, 在所有 Java 提交中击败了69.18%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了87.22%的用户
     * @param root
     * @return
     */
    public List<Double> averageOfLevelsLeetCode(TreeNode root) {
        List<Double> averages = new ArrayList<Double>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }
}
