package Top101.LinkedList;

public class BM2_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        // 定义前序节点和当前节点
        ListNode pre = res;
        ListNode cur = head;
        // 将 cur 移动到 m位置
        for (int i = 1; i < m; ++i) {
            pre = cur;
            cur = cur.next;
        }
        // 固定 pre，从 m 反转到 n
        for (int i = m; i < n; ++i) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return res.next;
    }
}
