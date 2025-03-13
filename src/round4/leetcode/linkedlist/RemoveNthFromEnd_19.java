package round4.leetcode.linkedlist;

public class RemoveNthFromEnd_19 {
    /*
        删除链表的倒数第 n 个节点
        双指针，为方便删除加上虚拟头节点，让快指针先走 n + 1 步
        当快指针指向空时，刚好慢指针指向被删除节点的前一个节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义虚拟头节点，方便处理删除第一个节点的情况
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 快慢双指针
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        // 让快指针先走 n + 1 步，过程需要判空节点
        for (int i = 0; i <= n; i++) {
            if (fast == null)
                return head;
            fast = fast.next;
        }

        // 再同步向前走，快指针指向空时，刚好慢指针指向被删除节点的前一个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
