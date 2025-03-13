package round4.leetcode.linkedlist;

public class HasCycle_141 {
    /*
        环形链表
        快慢指针判断链表是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            // 同时指向头部，判断是否有环需要先移动
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
