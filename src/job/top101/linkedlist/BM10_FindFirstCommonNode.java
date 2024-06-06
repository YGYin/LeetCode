package job.top101.linkedlist;

public class BM10_FindFirstCommonNode {
    /*
        两个链表的第一个公共结点(链表相交)
        双指针分别遍历 A B 链表
        如果其中一个为空，则开始遍历另外一条链表
        本质上为 A + B = B + A
        如果有公共节点的话，第一遍遍历已经填补差值，最后会在公共节点相遇
        如果没有公共节点，则一起到结尾 NULL
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode ptr1 = pHead1;
        ListNode ptr2 = pHead2;
        while (ptr1 != ptr2) {
            if (ptr1 == null)
                ptr1 = pHead2;
            else
                ptr1 = ptr1.next;
            if (ptr2 == null)
                ptr2 = pHead1;
            else
                ptr2 = ptr2.next;
        }
        return ptr1;
    }
}
