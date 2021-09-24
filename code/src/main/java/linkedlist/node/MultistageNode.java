package linkedlist.node;

/**
 * @author hawk
 * @package linkedlist
 * @desc
 * @date 2021/9/24
 */
public class MultistageNode {
    public int val;
    public MultistageNode prev;
    public MultistageNode next;
    public MultistageNode child;

    public MultistageNode() {
    }

    public MultistageNode(int val) {
        this.val = val;
    }

    public MultistageNode(int val, MultistageNode prev, MultistageNode next, MultistageNode child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }
}
