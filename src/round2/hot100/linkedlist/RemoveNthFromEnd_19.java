package round2.hot100.linkedlist;

public class RemoveNthFromEnd_19 {
    /*
        删除链表的倒数第 N 个结点
        双指针，先让快指针先走 n + 1 步，两个指针中间空隔 n 个节点
        然后两个指针同时向前遍历
        当快指针指向空时，慢指针刚好指向被删除节点的前一节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟头节点，方便统一处理删除第一个节点的情况
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode pre = dummyHead;
        // 先向前走 n + 1 步
        for (int i = 0; i < n + 1; i++)
            cur = cur.next;

        // 然后 pre 和 cur 同时向前移动，当 cur 为空时，pre 正好指向被删除节点的前一节点
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;

        return dummyHead.next;
    }
}
