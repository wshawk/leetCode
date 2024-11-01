package leetcode.linkedlist;


import leetcode.linkedlist.node.ListNode;

/**
 * @author hawk
 * @package leetcode.linkedlist
 * @desc 725. 分隔链表
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * <p>
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * <p>
 * 返回一个由上述 k 部分组成的数组。
 * <p>
 *  
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 1000]
 * 0 <= Node.val <= 1000
 * 1 <= k <= 50
 * @date 2021/9/22
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode[] res = splitListToParts(ListNode.generateListNode(new int[]{1, 2, 3}), 5);
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        // 获取到每一段的平均长度
        int quotient = len / k;
        // 产生的余数
        int remainder = len % k;
        ListNode[] parts = new ListNode[k];

        ListNode curr = head;
        // 条件curr不等于null
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            // 计算每一段应该包含几个节点，很精妙
            int partSize = quotient + (i < remainder ? 1 : 0);
            // 这里的初始值为 1， 是因为前面已经对 0 位上赋值了。
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}
