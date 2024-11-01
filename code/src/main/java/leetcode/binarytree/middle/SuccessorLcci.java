package leetcode.binarytree.middle;

import leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawk
 * @package leetcode.binarytree.middle
 * @desc  面试题 04.06. 后继者
 * @date 2021/6/4
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 示例 1:
 *
 * 输入: root = [2,1,3], p = 1
 *
 *   2
 *  / \
 * 1   3
 *
 * 输出: 2
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * 输出: null
 * 通过次数15,989提交次数27,105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/successor-lcci
 */
public class SuccessorLcci {
    /**
     * TODO: 待解决
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> middleOrder = new ArrayList<>();
        return null;
    }

}
