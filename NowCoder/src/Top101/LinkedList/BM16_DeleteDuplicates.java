package Top101.LinkedList;

public class BM16_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 方便删除第一个节点，加链表头
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            // 若相邻两个节点相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                // 将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp)
                    cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        return res.next;
    }
}
