package leetcode.binarytree.easy;

import leetcode.binarytree.MultiTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.easy
 * @desc 559. N 叉树的最大深度
 * @date 2021/6/10
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 *
 *
 * 提示：
 *
 * 树的深度不会超过1000 。
 * 树的节点数目位于 [0,104] 之间。
 * 通过次数52,600提交次数72,826
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 */
public class MaximumDepthOfNAryTree {
    /**
     * BFS
     * @param root
     * @return
     */
    public int maxDepth(MultiTreeNode root) {
        if (root == null) return 0;
        Queue<MultiTreeNode> queue = new LinkedList<MultiTreeNode>(){{offer(root);}};
        int maxDepth = 0;
        while (!queue.isEmpty()){
            for (int i=0,len= queue.size(); i<len; i++){
                MultiTreeNode n = queue.poll();
                if (n.children != null && n.children.size() > 0){
                    for (MultiTreeNode node: n.children){
                        queue.offer(node);
                    }
                }
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * 简化版
     * @param root
     * @return
     */
    public int maxDepthBetter(MultiTreeNode root) {
        if (null == root) {
            return 0;
        }
        int result = 1;
        for (MultiTreeNode child : root.children) {
            result = Math.max(result, 1 + maxDepthBetter(child));
        }
        return result;
    }
}
