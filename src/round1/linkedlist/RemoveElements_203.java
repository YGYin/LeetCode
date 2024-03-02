package round1.linkedlist;

public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 使用前后节点便于处理
        // pre 负责更新链表
        // cur 负责探路寻找需要被删除的节点
        ListNode pre = dummyHead;
        ListNode cur = head;
        // 首先确保头节点不为空
        while (cur != null) {
            // 如果当前节点为要移除的元素，将 pre 的 next 指针指向下下个元素
            if (cur.val == val)
                pre.next = cur.next;
                // 如果不需删除，更新 pre 指针
            else
                pre = cur;
            // 前移 cur 指针
            cur = cur.next;
        }

        return dummyHead.next;
    }
}
