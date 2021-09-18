package linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author hawk
 * @package linkedlist
 * @desc  剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @date 2021/9/18
 */
public class PrintLinkedListFromTailToHead {
    public static void main(String[] args) {
        Arrays.stream(reversePrint(ListNode.generateListNode(new int[]{1, 2, 3}))).forEach(System.out::println);
    }

    /**
     * 用map进行存储，然后反填。
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        int count = 0;
        if (head == null){
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (head != null){
            map.put(count, head.val);
            head = head.next;
            count++;
        }
        int[] res = new int[map.size()];
        for (int i=0; i<res.length; i++){
            res[i] = map.get(res.length-(i+1));
        }
        return res;
    }

    /**
     * 利用栈的特性进行反转
     * @param head
     * @return
     */
    public static int[] reversePrintByStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return res;
    }
}
