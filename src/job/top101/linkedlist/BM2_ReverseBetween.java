package job.top101.linkedlist;

public class BM2_ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1 -> 2 -> 3 -> 4 -> 5  2  4
        // 1 -> 4 -> 3 -> 2 -> 5
        // 1 -> 2 -> 3 -> 4 -> 5  2  4
        // 1 -> 4 -> 3 -> 2 -> 5
        if (m == n)
            return head;
        // 需要 dummyHead 来使得指针刚好指向被翻转的起始点的前一个节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        // pre 指向 m 的前一节点
        for (int i = 1; i < m; i++)
            pre = pre.next;
        // 指向 m
        ListNode cur = pre.next;
        // 1 -> 2 -> 3 -> 4 -> 5
        // 保存 3 为 temp
        // 先让 2 -> 4；然后 3 -> 2，1 -> 3
        for (int i = 0; i < n - m; i++) {
            // 记录节点 3
            ListNode temp = cur.next;
            // 节点 2 指向节点 4
            cur.next = temp.next;
            // 节点 3 指向节点 2
            temp.next = pre.next;
            // 节点 1 指向节点 3
            pre.next = temp;
        }

        return dummyHead.next;
    }

}
