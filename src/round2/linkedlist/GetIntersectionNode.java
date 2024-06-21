package round2.linkedlist;

public class GetIntersectionNode {
    /*
        链表相交，返回两个单链表相交的起始节点
        双指针分别遍历两个链表，要是最后有相同节点则为入口节点，都为空则不存在相交节点
        原理: a + b = b + a
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        // 两个指针最终一定相等，要么都指向空要么指向入口节点
        while (ptr1 != ptr2) {
            // 分别遍历两条链表，当有一个为空时换到另外一条链表继续遍历
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }

        return ptr1;
    }
}
