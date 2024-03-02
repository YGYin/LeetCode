package round1.linkedlist;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 因为可能删除的是头节点
        // 为了避免需要额外处理逻辑，增加虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slowP = dummyHead;
        ListNode fastP = dummyHead;
        // 让快指针先走 n + 1 步
        // 以达到让慢指针指向倒数第 n 个节点的前一个节点的目的
        // 因为题目条件 n <= 节点数，不需要额外处理
        n++;
        for (int i = 0; i < n; i++)
            fastP = fastP.next;
        // 让快慢指针同时移动直至快指针为空（到末尾）
        while (fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next;
        }
        // 删除节点
        slowP.next = slowP.next.next;

        return dummyHead.next;
    }
}
