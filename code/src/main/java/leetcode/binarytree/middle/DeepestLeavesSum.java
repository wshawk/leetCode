package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc 1302. 层数最深叶子节点的和
 * @date 2021/6/3
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 104]之间。
 * 1 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/deepest-leaves-sum
 */
public class DeepestLeavesSum {
    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了24.94%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了85.05%的用户
     *
     * 思路：
     * 按顺序将每层的节点数据之和添加到list中
     * 取list的最后一个元素即可
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        List<Integer> r = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{offer(root);}};
        while (!queue.isEmpty()){
            int sum = 0;
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode n = queue.poll();
                sum += n.val;
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            r.add(sum);
        }
        return r.get(r.size() - 1);
    }

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了49.87%的用户
     * 内存消耗：39.4 MB, 在所有 Java 提交中击败了81.53%的用户
     *
     * 相比较上一个方法，不用把每一层的结果放到list中
     * 直接判断是不是最后一层，如果是最后一层就返回该层数据之和
     * @param root
     * @return
     */
    public int deepestLeavesSumMaybeBetter(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{offer(root);}};
        while (!queue.isEmpty()){
            int sum = 0;
            for (int i=0,len=queue.size(); i<len; i++){
                TreeNode n = queue.poll();
                sum += n.val;
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            // 判断是否是最后一层
            if (queue.size() == 0){
                return sum;
            }
        }
        throw null;
    }
}
