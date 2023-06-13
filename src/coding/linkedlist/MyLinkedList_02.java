package coding.linkedlist;

public class MyLinkedList_02 {
    ListNode head;
    int size;

    public MyLinkedList_02() {
        head = new ListNode(0);
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        ListNode cur = head;
        // 因为有一个虚拟头节点，所以查找第 index + 1 个节点
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
        if (index > size)
            return;
        if (index < 0)
            index = 0;
        ++size;
        // 找到要插入的节点的前节点
        ListNode pre = head;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    // 删除第 index 个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        --size;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode pre = head;
        for (int i = 0; i < index; i++)
            pre = pre.next;
        pre.next = pre.next.next;
    }
}
