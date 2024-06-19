package round2.linkedlist;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        // 翻转链表，可以不用头节点
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
