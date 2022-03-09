package linkedlist.node;

/**
 * @author hawk
 * @package linkedlist.node
 * @date 2022/3/8
 * @desc 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 * 如果 index 大于链表长度，则不会插入节点。
 * 如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * 示例：
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class MyLinkedList {
    // 结点类
    class Node {
        // 结点的值
        int val;
        // 指向下一个结点的指针(java中表现为下一个结点的引用)
        Node next;

        // 初始化 数据域val
        Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node head;


    // 初始化  构造方法
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    // 获取指定 索引index 的结点
    // 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        Node t = head;
        for (int i = 0; i <= index; i++) {
            t = t.next;
        }
        return t.val;
    }

    // 头部插入
    // 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 尾部插入
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 任意插入
    // 在链表中的第 index 个节点之前添加值为 val  的节点。
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。
    // 如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            index = 0;
        }
        if (index > size) {
            return;
        }

        Node t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        Node newNode = new Node(val);
        newNode.next = t.next;
        t.next = newNode;
        size++;
    }

    // 删除
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        Node t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }

        t.next = t.next.next;
    }

}
