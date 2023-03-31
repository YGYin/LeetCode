package Top101.LinkedList;

public class BM8_FindKthToTail {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        ListNode slowP = pHead;
        ListNode fastP = pHead;
        // 快指针先走 k 步
        for (int i = 0; i < k; ++i) {
            // 链表长度小于 k 时
            if (fastP == null)
                return null;
            fastP = fastP.next;
        }
        // 让快慢指针保持相对距离 k, 快指针先到底，慢指针指向倒数第 k 个
        while (fastP != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        return slowP;
    }

    public ListNode FindKthToTail_2(ListNode pHead, int k) {
        int count = 0;
        ListNode ptr = pHead;
        //遍历链表，统计链表长度
        while (ptr != null) {
            ++count;
            ptr = ptr.next;
        }
        //长度过小，返回空链表
        if (count < k)
            return null;
        ptr = pHead;
        //遍历 n - k 次
        for (int i = 0; i < count - k; ++i)
            ptr = ptr.next;
        return ptr;
    }
}
