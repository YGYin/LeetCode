package Top101.LinkedList;

public class BM15_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 遍历指针
        ListNode cur = head;
        // 指针和当前下一位不为空
        while (cur != null && cur.next != null) {
            // 相等则忽略下一位，直到 next 指向和自己不相等的节点
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
                // 否则正常遍历节点
            else
                cur = cur.next;
        }
        return head;
    }
}
