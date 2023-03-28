package Top101.LinkedList;

public class BM6_HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        // 定义快慢双指针
        ListNode slowP = head;
        ListNode fastP = head;
        // 如果没有环快指针先到链表尾部
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            // 快慢指针相遇则有环
            if (slowP == fastP)
                return true;
        }
        return false;
    }
}
