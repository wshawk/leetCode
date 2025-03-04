package linkedlist;

import linkedlist.node.ListNode;

import java.util.List;

/**
 * @author hawk
 * @package linkedlist
 * @desc 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * @date 2021/9/3
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        // ListNode head = ListNode.generateListNode(new int[]{1, 2, 3, 4, 5});
        // System.out.println(removeNthFromEnd(head, 2));

        System.out.println(27%3);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i=0; i<n; i++){
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
