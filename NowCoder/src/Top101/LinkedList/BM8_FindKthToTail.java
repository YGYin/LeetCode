package Top101.LinkedList;

public class BM8_FindKthToTail {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode slowP = pHead;
        ListNode fastP = pHead;
        // 快指针先走 k 步
        for (int i = 0; i < k; ++i) {
            // 链表长度小于 k 时
            if (fastP == null)
                return slowP = null;
            fastP = fastP.next;
        }
        // 让快慢指针保持相对距离 k, 快指针先到底，慢指针指向倒数第 k 个
        while (fastP != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        return slowP;
    }
}
