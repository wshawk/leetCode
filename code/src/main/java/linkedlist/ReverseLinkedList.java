package linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public ListNode reverseList(ListNode head) {
        // 先进后出，考虑使用栈来解决
        if(head == null) return null;
        Queue<Integer> queue = new LinkedList<>();
        ListNode root = head;
        while (head.val !=0){
            queue.offer(head.val);
           if (head.next != null){
               head = head.next;
           }else{
               break;
           }
        }
        ListNode reverse = new ListNode();
        reverse.val = queue.poll();
        while (!queue.isEmpty()) {
            if (reverse.next == null) {
                reverse.next = new ListNode(queue.poll());
            } else {

            }
        }
        return null;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = ListNode.generateListNode(new int[]{1, 2, 3});
        System.out.println("------------");
    }


}
