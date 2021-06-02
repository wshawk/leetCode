package binarytree.middle;

import binarytree.MultiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hawk
 * @package binarytree.middle
 * @desc 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 提示：
 *
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 * 通过次数47,868提交次数69,218
 *
 * @date 2021/6/1
 */
public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        MultiTreeNode root = new MultiTreeNode(1);
        List<MultiTreeNode> rootChildren = new ArrayList<>();

        MultiTreeNode firstNode = new MultiTreeNode(3);
        List<MultiTreeNode> firstNodeChildren = new ArrayList<>();
        firstNodeChildren.add(new MultiTreeNode(5));
        firstNodeChildren.add(new MultiTreeNode(6));
        firstNode.children = firstNodeChildren;

        MultiTreeNode secondNode = new MultiTreeNode(2);
        MultiTreeNode threeNode = new MultiTreeNode(4);

        rootChildren.add(firstNode);
        rootChildren.add(secondNode);
        rootChildren.add(threeNode);
        root.children = rootChildren;

        List<List<Integer>> r = levelOrder(root);
        r.forEach(System.out::println);
    }
    /**
     * 迭代思路：
     * 使用队列来处理
     * @param root N叉树
     * @return 层序遍历结果
     */
    public static List<List<Integer>> levelOrder(MultiTreeNode root) {
      List<List<Integer>> ret = new ArrayList<>();
      if (root == null) return ret;
      Queue<MultiTreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()){
          List<Integer> level = new ArrayList<>();
          int levelSize = queue.size();
          for (int i = 0; i < levelSize; i++) {
                MultiTreeNode node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
          }
          ret.add(level);
      }
      return ret;
    }
}
