package leetcode.linkedlist;

import leetcode.linkedlist.node.MultistageNode;

/**
 * @author hawk
 * @package leetcode.linkedlist
 * @desc 430. 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *
 *
 * 扁平化后的链表如下图：
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 * 1---2---NULL
 * |
 * 3---NULL
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 如何表示测试用例中的多级链表？
 *
 * 以 示例 1 为例：
 *
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * 序列化其中的每一级之后：
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 *
 * 提示：
 *
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 * @date 2021/9/24
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        MultistageNode node = new MultistageNode(1);
        MultistageNode two = new MultistageNode(2);
        node.next = two;
        two.prev = node;

        MultistageNode three = new MultistageNode(3);
        three.prev = two;
        two.next = three;

        MultistageNode four = new MultistageNode(4);
        four.prev = three;
        three.next = four;

        MultistageNode five = new MultistageNode(5);
        five.prev = four;
        four.next = five;

        MultistageNode six = new MultistageNode(6);
        six.prev = five;
        five.next = six;


        MultistageNode seven = new MultistageNode(7);
        three.child = seven;

        MultistageNode eight = new MultistageNode(8);
        seven.next = eight;
        eight.prev = seven;

        MultistageNode nine = new MultistageNode(9);
        nine.prev = eight;
        eight.next = nine;

        MultistageNode ten = new MultistageNode(10);
        ten.prev = nine;
        nine.next = ten;

        MultistageNode eleven = new MultistageNode(11);
        eight.child = eleven;

        MultistageNode twelve = new MultistageNode(12);
        twelve.prev = eleven;
        eleven.next = twelve;

        MultistageNode res = flatten(node);
        System.out.println("=================================");

    }
    /**
     * 思路：
     *      - 遍历链表
     *          - 如果当前节点存在子节点，将当前节点的next指向子节点头节点，将当前节点的next节点的pre指向子节点的尾节点
     *          - 不存在子节点，跳过
     *          - 遍历到尾节点之后结束
     * @param head
     * @return
     */
    public static MultistageNode flatten(MultistageNode head) {
        if(head == null){
            return null;
        }
        MultistageNode curr = head;
        while (curr.next != null){
            MultistageNode next = curr.next;
            MultistageNode child = curr.child;
            MultistageNode childN = child;
            if (child != null){
                curr.next = child;
                child.prev = curr;

                // 处理child的尾节点
                while (childN.next != null){
                    childN = childN.next;
                }
                childN.next = next;
                next.prev = childN;
            }
            curr = curr.next;
        }
        return curr;
    }

}
