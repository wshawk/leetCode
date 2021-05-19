package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hawk
 * @package linkedlist
 * @desc
 *
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @date 2021/2/24
 */
public class ReverseLinkedList {
    /**
     * 迭代解法
     *
     * @param head 需要反转的链表
     * @return 反转后的链表
     */
    public static ListNode reverseList(ListNode head) {
        // ListNode cur = head;
        // ListNode pre = null;
        // while(cur != null){
        // 假设获取到的链表是 1 -> 2 -> 3 -> null
        // curr 为 1 -> 2 -> 3 -> null
        // 获取当前节点的下一个节点, 拿到 2 -> 3 -> null
        //     ListNode next = cur.next;
        // 1 -> null
        //     cur.next = null;
        //     next.next = cur;
        //     cur = next;
        // }
        // return cur;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 假设获取到的链表是 1 -> 2 -> 3 -> null
            // curr 为 1 -> 2 -> 3 -> null
            // 获取当前节点的下一个节点, 拿到 2 -> 3 -> null
            ListNode next = curr.next;
            // 将当前节点的下一个节点设值为当前节点的上一个节点
            // 1 -> null
            curr.next = prev;
            // 将当前节点设置为下一个节点的前置节点，即挪动前置节点的指针
            // prev = 1
            prev = curr;
            // curr 为 2 -> 3 -> null
            // 此时pre链表为 1 -> null
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode head = ListNode.generateListNode(new int[]{1, 2, 3});
        ListNode result = reverseList(head);
        System.out.println("ppppppppppp");
    }
    public static ListNode test(ListNode head){
        ListNode node = head;
        return null;
    }

}
