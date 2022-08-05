package linkedlist;

import linkedlist.node.ListNode;

import java.util.List;

/**
 * @author hawk
 * @package linkedlist
 * @desc 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * @date 2021/9/3
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != null && fast.next != null){
            if (fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

        } while (fast != slow);

        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
