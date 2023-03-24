package Top101.LinkedList;

public class BM1_ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head, pre = null;
        while (cur != null) {
            // 记录后续一个
            ListNode temp = cur.next;
            // 指向前一个节点
            cur.next = pre;
            // 更新 pre 为当前节点
            pre = cur;
            // 更新 cur
            cur = temp;
        }
        return pre;
    }
}
