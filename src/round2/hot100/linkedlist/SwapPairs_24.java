package round2.hot100.linkedlist;

public class SwapPairs_24 {
    /*
     * 设置虚拟头节点，分为 1 2 3 号节点
     * 分为三步:
     * 1. 当前节点指向 2 号节点
     * 2. 2 号节点指向 1 号节点
     * 3. 1 号节点指向 3 号节点
     *
     * 再将当前指针更新到 1 号节点
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            ListNode third = cur.next.next.next;

            cur.next = second;
            second.next = first;
            first.next = third;
            cur = first;
        }

        return dummyHead.next;
    }
}
