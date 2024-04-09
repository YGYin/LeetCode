package round1.hot100.linkedlist;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        // 定义 pre 指针指向当前指针的前一个节点
        // 定义 nextTemp 在当前节点指向前一个节点前，用于储存下一节点
        if (head == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextTemp;
        while (cur != null) {
            nextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
}
