package round2.linkedlist;


public class MyLinkedList {
    // 储存链表中节点个数
    int size;
    // 需要虚拟头节点
    ListNode dummyHead;

    public MyLinkedList() {
        // 初始化头节点，节点数为 0
        dummyHead = new ListNode(-1);
        this.size = 0;
    }

    /*
        获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
     */
    public int get(int index) {
        // 判断是否为非法下标
        if (index < 0 || index >= size)
            return -1;
        // 遍历链表，下标从 0 开始，需要到达 index，<= index
        ListNode cur = dummyHead;
        for (int i = 0; i <= index; i++)
            cur = cur.next;

        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 判断是否为非法下标，index == size 时为在尾部插入
        if (index > size)
            return;
        if (index < 0)
            index = 0;

        ListNode pre = dummyHead;
        // 到达插入前一个节点的位置
        for (int i = 0; i < index; i++)
            pre = pre.next;

        // 插入节点，先记录下一节点
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        // index = size 时非法，一共只有 size 个节点
        // index 为 0 的时候为真实头节点
        if (index < 0 || index >= size)
            return;
        ListNode pre = dummyHead;
        // 到达删除节点的前一个节点
        for (int i = 0; i < index; i++)
            pre = pre.next;

        pre.next = pre.next.next;
        --size;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
