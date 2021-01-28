package binarytree;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author hawk
 * @package binarytree
 * @desc
 * 572. 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * @date 2021/1/28
 */
public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode s = TreeNodeUtils.generateBinaryTree(new Integer[]{94, 95, 95, 94, 96, 94, 96, 95, 95, 95, 97, 93, null, null, 95, 94, 96, 94, null, 94, 96, 96, 98, null, null, null, null, 93, 93, 95, 95, 93, 95, 93, 95, 97, 97, null, 95, 97, 97, 92, 92, 92, 94, null, 96, 96, 96, 92, 92, 96, 96, 92, null, null, 96, 98, 98, 98, null, null, null, 96, 98, null, null, null, 93, 91, 93, null, 93, 93, 93, null, 97, 95, 95, 97, 97, null, 93, 91, null, 95, 97, 95, 97, 91, null, null, null, 97, 99, null, 99, null, 99, 95, null, 97, 97, 92, 92, 90, null, 92, 94, 92, 92, 94, 92, 94, 94, null, null, 94, null, null, null, 96, null, 98, null, null, null, null, 92, 96, 94, null, 98, 94, null, 98, null, 90, null, null, null, 98, null, null, null, null, null, 94, null, 96, 96, 98, null, null, null, null, 91, null, 91, null, 93, null, 95, null, 93, null, null, 95, null, null, null, null, null, null, null, null, null, 95, 97, 97, 99, 91, 93, null, null, 93, 95, 97, 97, null, null, 97, 99, null, null, null, null, null, null, null, 97, null, 97, 97, null, 90, 90, null, 92, null, null, null, null, 94, 94, null, null, null, null, 98, 96, null, null, null, 98, null, 90, null, null, 92, 92, null, 96, null, null, null, null, null, null, 100, null, null, null, null, null, null, null, null, null, null, null, 91, null, null, null, null, 95, null, 99, 97, 97, null, null, null, null, 93, 91, 93, null, 95, null, null, null, null, null, null, null, null, 98, null, null, 96, null, null, null, 90, null, 92, null, null, null, null, null, null, null, 89});
        TreeNode t = TreeNodeUtils.generateBinaryTree(new Integer[]{92});

        // s = [1,1,1]
        // t =  [1]
        // 预期：true  通过

        // s = [3,4,5,1,null,2]
        // t = [3,1,2]
        // 预期：false  通过

        // s = [1,1]
        // t =[1]
        // 预期：true   通过

        // s = [3,4,5,1,2]
        // t = [4,1,2,1]

        System.out.println(isSubtree(s, t));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        // 前序遍历t，存储到list中, List<Integer>
        // 前序遍历s，把s的每一个子树遍历的结果放到list中即List<List<Integer>>
        // 如果第二个List<List<Integer>>中有一个元素，和上面的遍历结果相同，就说明t是s的子树，否则就不是
        List<Integer> tList = new ArrayList<>();
        preOrder(t, tList);

        List<List<Integer>> sList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            List<Integer> list = new ArrayList<>();
            preOrder(cur, list);
            sList.add(list);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        boolean flag = true;
        for (List<Integer> integers : sList) {
            if (integers.size() == tList.size()) {
                for (int i = 0, len = tList.size(); i < len; i++) {
                    if (!integers.get(i).equals(tList.get(i))) {
                        flag = false;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void preOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }


    /**
     * 官方题解DFS
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtreeLeetcode(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }
}