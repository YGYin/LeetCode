package job.top101.linkedlist;

public class BM8_FindKthToTail {
    /*
        链表中倒数最后k个结点
        1. 为了方便处理设置 dummyHead
        2. 双指针，让快指针先走 k 步，产生 k 个 空格；然后两个指针同时移动
        3. 当快指针为空时，慢指针刚好指向倒数第 k 个节点
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (pHead == null)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = pHead;
        ListNode slowP = dummyHead;
        ListNode fastP = dummyHead;
        for (int i = 0; i < k; i++) {
            fastP = fastP.next;
            // 有可能链表长度小于 k
            if (fastP == null)
                return null;
        }

        while (fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next;
        }
        return slowP;
    }
}
