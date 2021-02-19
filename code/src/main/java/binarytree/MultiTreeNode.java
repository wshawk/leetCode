package binarytree;

import java.util.List;

/**
 * @author hawk
 * @package binarytree
 * @desc 多叉树实体对象
 * @date 2021/2/19
 */
public class MultiTreeNode {
    public int val;
    public List<MultiTreeNode> children;

    public MultiTreeNode() {}

    public MultiTreeNode(int val) {
        this.val = val;
    }

    public MultiTreeNode(int val, List<MultiTreeNode> children) {
        this.val = val;
        this.children = children;
    }
}
