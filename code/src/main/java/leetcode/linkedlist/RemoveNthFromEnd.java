package leetcode.linkedlist;

import leetcode.linkedlist.node.ListNode;

/**
 * @author hawk
 * @package leetcode.linkedlist
 * @desc 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @date 2025/2/27
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result =  new ListNode(0);
        result.next = head;

        ListNode fast = result;
        ListNode slow = result;

        while (n != 0){
            fast = fast.next;
            n--;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return result.next;

    }
}
