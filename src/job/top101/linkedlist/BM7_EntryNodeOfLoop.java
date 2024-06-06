package job.top101.linkedlist;

public class BM7_EntryNodeOfLoop {
    /*
        链表中环的入口节点
        与 leetcode 不同的是，本题不一定有环，且存在空链表，需要特判
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 特判空链表
        if (pHead == null)
            return null;
        ListNode slowP = pHead;
        ListNode fastP = pHead;
        // 有可能无环，需要判断快指针以及其 next 是否为空
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            // 移动完判断是否相等(可能都为空)，相等则 break
            if (slowP == fastP)
                break;
        }
        // 特判没有环，快慢指针都为空的情况
        if (fastP == null || fastP.next == null)
            return null;
        // 链表有环
        ListNode ptr1 = pHead;
        ListNode ptr2 = fastP;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
