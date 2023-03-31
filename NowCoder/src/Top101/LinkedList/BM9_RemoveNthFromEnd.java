package Top101.LinkedList;

public class BM9_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 添加表头
        ListNode res = new ListNode(-1);
        res.next = head;
        // 定义前序节点
        ListNode pre = res;
        // 当前节点以及快指针
        ListNode cur = head;
        ListNode fastP = head;
        // 快指针先走 n 步
        for (int i = 0; i < n; ++i) {
            if (fastP == null)
                return null;
            fastP = fastP.next;
        }

        // 保持相对距离 n, 快指针先到链表尾部
        while (fastP != null) {
            fastP = fastP.next;
            pre = cur;
            cur = cur.next;
        }
        // 删除当前 cur 节点，返回链表的头指针
        pre.next = cur.next;
        return res.next;
    }
}
