package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc 1161. 最大层内元素和
 * @date 2021/6/2
 * 给你一个二叉树的根节点root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数介于1和10^4之间
 * -10^5 <= node.val <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree
 */
public class MaximumLevelSumOfABinaryTree {
    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了10.31%的用户
     * 内存消耗：41.1 MB, 在所有 Java 提交中击败了78.42%的用户
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            offer(root);
        }};
        Integer level = 1;
        Map<Integer, Integer> levelSumMap = new HashMap<>();
        while (!queue.isEmpty()){
            Integer levelSum = 0;
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode node = queue.poll();
                levelSum = levelSum + node.val;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            levelSumMap.put(level, levelSum);
            level++;
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(levelSumMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        return list.get(0).getKey();
    }

    /**
     * bad
     * @param root
     * @return
     */
    public int maxLevelSumMayBeBetter(TreeNode root) {
        if (root == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            offer(root);
        }};
        Integer level = 1;
        Integer maxLevel = 1;
        Integer sum = 0;
        Map<Integer, Integer> levelSumMap = new HashMap<>();
        while (!queue.isEmpty()){
            Integer levelSum = 0;
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode node = queue.poll();
                levelSum = levelSum + node.val;
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (levelSum > sum){
                    sum = levelSum;
                    maxLevel = level;
                }
                level++;
            }
        }
        return maxLevel;
    }
}
