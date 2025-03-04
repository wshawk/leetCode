package leetcode.linkedlist;

import leetcode.linkedlist.node.ListNode;

/**
 * @author hawk
 * @package leetcode.linkedlist
 * @desc
 * @date 2025/2/19
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode he = headA;
        ListNode she = headB;

        while (he != she){
            he = he == null ? headB : he.next;
            she = she == null ? headA : she.next;
        }
        return she;
    }

}
