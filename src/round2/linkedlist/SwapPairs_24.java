package round2.linkedlist;

public class SwapPairs_24 {
    /*
        两两交换链表中的节点
        dummyHead -> 1 -> 2 -> 3 -> ...
        dummyHead -> 2 -> 1 -> 3 -> ...
        需要记录第二节点的下一节点 temp，方便交换完之后连接
        1. 先用当前节点指向第二节点
        2. 第二节点指向第一节点
        3. 最后，让第一个节点指向记录的 temp

     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 虚拟头节点，方便两两交换
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // 当下一对要交换节点不为空
        while (cur.next != null && cur.next.next != null) {
            // 记录下第二个节点的下一个节点
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            ListNode temp = cur.next.next.next;
            cur.next = second;
            second.next = first;
            first.next = temp;
            // 移动指针到下一对的前一个节点
            cur = first;
        }
        return dummyHead.next;
    }
}
