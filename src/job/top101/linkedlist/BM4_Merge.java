package job.top101.linkedlist;

public class BM4_Merge {
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // 使用 dummyHead 便于返回链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (pHead1 != null && pHead2 != null) {
            // cur.next 接上较小的节点
            if (pHead1.val <= pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            // 移动 next 指针
            cur = cur.next;
        }
        // 将不为空剩余的链表接上
        cur.next = pHead1 == null ? pHead2 : pHead1;
        return dummyHead.next;
    }
}
