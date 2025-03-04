package leetcode.linkedlist.node;

/**
 * @author hawk
 * @package leetcode.linkedlist
 * @desc
 * @date 2021/1/29
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode generateListNode(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        for (int num : nums) {
            preNode.next = new ListNode(num);
            preNode = preNode.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        return val +" => " + (next == null ? "null" : next.toString());
    }
}
