package Top101.LinkedList;

public class BM2_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 虚拟链表头
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        // 将 cur 指向 m
        for (int i = 0; i < m - 1; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 从 m 反转到 n
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return res.next;
    }
}