package round2.hot100.linkedlist;

public class HasCycle_141 {
    /*
        环形链表
        快慢指针判断链表是否存在环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        // 快慢指针判断链表是否存在环
        ListNode slowP = head;
        ListNode fastP = head;
        // 快指针每次走两步
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP)
                return true;
        }

        return false;
    }
}
