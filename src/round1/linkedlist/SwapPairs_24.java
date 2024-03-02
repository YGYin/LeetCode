package round1.linkedlist;

public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode temp1, temp2;
        while (cur.next != null && cur.next.next != null) {
            // 缓存 1 3节点
            temp1 = cur.next;
            temp2 = cur.next.next.next;
            // cur.next -> 2nd
            cur.next = cur.next.next;
            // cur.next.next -> 1st
            cur.next.next = temp1;
            // cur.next.next.next -> 3
            cur.next.next.next = temp2;
            // 更新指针
            cur = cur.next.next;
        }
        return dummyHead.next;
    }
}
