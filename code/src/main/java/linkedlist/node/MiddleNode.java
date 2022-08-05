package linkedlist.node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hawk
 * @package linkedlist.node
 * @desc
 * @date 2022/7/27
 */
public class MiddleNode {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateListNode(new int[]{1, 2, 3, 4, 5});
        // middleNode(listNode);
        System.out.println(middleNodeFastAndSlow(listNode));
    }


    public static ListNode middleNodeFastAndSlow(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;

        while (head != null){
            ++index;
            map.put(index, head);
            head = head.next;
        }
        // 偶数
        int ansIndex = 0;
        if ((index & 1) != 1){
            ansIndex = (index / 2) + 1;
        }else{
            ansIndex = (index + 1) / 2;
        }
        return map.get(ansIndex);

    }
}
