package round2.linkedlist;

public class RemoveNthFromEnd_19 {
    /*
        删除链表的倒数第 N 个结点
        快慢指针，先让快指针走 N + 1 步，相当于快慢指针之间间隔 N 个节点
        然后让快指针指向末尾空，此时慢指针刚好指向被删除节点的前一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 新建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 快慢指针
        ListNode fastP = dummyHead;
        ListNode slowP = dummyHead;

        // 先走 n + 1 步，间隔出 n 个节点
        for (int i = 0; i <= n; i++)
            fastP = fastP.next;

        // 一直往前移动直到快指针刚好指向空
        while (fastP != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        // 删除节点
        slowP.next = slowP.next.next;

        return dummyHead.next;
    }
}
