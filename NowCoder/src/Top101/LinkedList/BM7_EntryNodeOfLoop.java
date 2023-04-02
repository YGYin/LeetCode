package Top101.LinkedList;

public class BM7_EntryNodeOfLoop {

    public ListNode returnFirstMeet(ListNode head) {
        if (head == null)
            return null;
        // 定义快慢双指针
        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP)
                return slowP;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slowP;
        // 没有环
        if ((slowP = returnFirstMeet(pHead)) == null)
            return null;
        // 快指针回到表头
        ListNode fastP = pHead;
        // 两指针再次相遇即为环入口
        while (fastP != slowP) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        return slowP;
    }
}
