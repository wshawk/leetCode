package linkedlist;

import linkedlist.node.ListNode;

import java.util.Stack;

/**
 * @author hawk
 * @package linkedlist
 * @desc
 * @date 2021/12/9
 */
public class Merge {
    public static void main(String[] args) {
        System.out.println(mergeTwoLists(ListNode.generateListNode(new int[]{1, 2, 4}), ListNode.generateListNode(new int[]{1, 3, 4})));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }
}
