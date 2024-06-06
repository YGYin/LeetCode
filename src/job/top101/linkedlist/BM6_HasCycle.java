package job.top101.linkedlist;

public class BM6_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP.next != null && fastP.next.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP)
                return true;
        }
        return false;
    }
}
