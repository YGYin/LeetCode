package round1.hot100.linkedlist;

public class HasCycle_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        // 快慢指针，在环内追逐
        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            // 要是存在环一定会在环内相遇
            if (slowP == fastP)
                return true;
        }
        return false;
    }
}
