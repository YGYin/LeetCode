package round1.linkedlist;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        // 此处可以不新建虚拟头节点
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextTmp;
        while (cur != null) {
            // 储存当前节点的下一节点
            nextTmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextTmp;
        }

        return pre;
    }
}
