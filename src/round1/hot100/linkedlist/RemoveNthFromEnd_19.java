package round1.hot100.linkedlist;

public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 因为删除的为第 N 个节点，需要让指针指向删除节点的前一个节点
        // 定义快慢双指针，先让快指针走 n + 1 步，然后双指针同时前移
        // 当快指针到尾部指向空时，慢指针到达需删除节点的前一节点

        // 定义虚拟头节点方便返回和处理，指向头部
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slowP = dummyHead;
        ListNode fastP = dummyHead;
        // 此处不需要处理 n，n 本身小于节点总数
        for (int i = 0; i < n + 1; i++)
            fastP = fastP.next;
        // 同时前移直到快指针为空
        while (fastP != null) {
            slowP = slowP.next;
            fastP = fastP.next;
        }
        // 删除节点
        slowP.next = slowP.next.next;

        return dummyHead.next;
    }
}
