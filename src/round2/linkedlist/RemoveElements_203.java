package round2.linkedlist;

public class RemoveElements_203 {
    /*
        移除链表元素
        1. 虚拟头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        // 定义虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // cur != null 确保调用 cur.next != null 时不会出现 npe
        while (cur != null && cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
