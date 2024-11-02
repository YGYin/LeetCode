package round3.hot100.linkedlist;

public class GetIntersectionNode_160 {
    /*
        相加链表
        利用 a + b = b + a
        - 同时从 a b 开始遍历，两者最终一定相等
        - 不相等期间如果 == null 说明到当前链表的末尾，则将其指针移动遍历另一条链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return headA;

        // 分别指向两个链表头
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }

        return p1;
    }
}
