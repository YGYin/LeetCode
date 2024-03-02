package round1.linkedlist;

public class MyLinkedList {
    // 链表储存节点个数
    int size;
    // 虚拟头节点
    ListNode dummyHead;

    // 初始化链表
    public MyLinkedList() {
        this.size = 0;
        this.dummyHead = new ListNode(0);
    }

    // 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1
    // index 从 0 开始，0 为头节点
    public int get(int index) {
        // 判断非法情况
        if (index < 0 || index >= size)
            return -1;
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

    // 在第 index 个节点之前插入一个新节点，
    // index 为 0，那么新插入的节点为链表的新头节点。
    // index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        // 处理非法情况
        if (index > size)
            return;
        if (index < 0)
            index = 0;
        // 因为要新增节点，增加 size
        ++size;
        // 指针指向要插入节点位置的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        // 新增节点，将该节点的 next 指向前继节点的下一节点
        // 再将前继节点的 next 指向新增节点
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    // 如果下标有效，则删除链表中下标为 index 的节点
    public void deleteAtIndex(int index) {
        // 处理非法情况
        if (index < 0 || index >= size)
            return;
        // 删除节点，减少 size
        --size;
        // 指针指向要插入节点位置的前一个节点
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        pre.next = pre.next.next;
    }
}
