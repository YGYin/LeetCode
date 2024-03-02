package round1.linkedlist;

public class DetectCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slowP = dummyHead;
        ListNode fastP = dummyHead;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                ListNode temp1 = head;
                ListNode temp2 = fastP;
                // 两个指针分别从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (temp1 != temp2) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                return temp1;
            }
        }

        return null;
    }
}
