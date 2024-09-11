package round2.hot100.linkedlist;

public class ReverseList_206 {
    /*
     * 反转链表
     * 定义 pre 为空，让 cur 指向 pre
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
