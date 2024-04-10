package round1.hot100.linkedlist;

public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        // 定义虚拟头节点和指针
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // 因为两两交换节点，需要保证下一节点个下下节点不为空
        while (cur.next != null && cur.next.next != null) {
            // 分别储存前三个节点
            ListNode firstNode = cur.next;
            ListNode secondNode = cur.next.next;
            ListNode thirdNode = cur.next.next.next;
            // 1. 先让当前节点指向第二节点
            cur.next = secondNode;
            // 2. 第二节点指向第一节点
            secondNode.next = firstNode;
            // 3. 第一节点再指向第三节点
            firstNode.next = thirdNode;
            // 将当前节点移动到第二个节点
            cur = firstNode;
        }
        return dummyHead.next;
    }
}
