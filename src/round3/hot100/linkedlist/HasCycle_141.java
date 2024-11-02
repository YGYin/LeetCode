package round3.hot100.linkedlist;

public class HasCycle_141 {
    /*
        环形链表
        快慢指针判断链表是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
