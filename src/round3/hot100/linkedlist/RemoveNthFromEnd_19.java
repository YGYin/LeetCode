package round3.hot100.linkedlist;

public class RemoveNthFromEnd_19 {
    /*
        删除链表的倒数第 n 个节点
        双指针，加上虚拟头节点，让快指针先走 n + 1 步；
        当快指针指向空时，刚好慢指针指向被删除节点的前一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        // 让快指针先走 n + 1 步
        for (int i = 0; i < n + 1; i++) {
            // 有可能还没到已经为空，直接返回
            if (fast == null)
                return head;
            fast = fast.next;
        }

        // 然后 快慢指针 同时移动，直到快指针为空
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 现在慢指针指向需要删除节点的前一个节点
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
