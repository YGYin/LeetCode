package round4.leetcode.linkedlist;

public class GetIntersectionNode_160 {
    /*
        相加链表
        利用 a + b = b + a
        - 同时从 a b 开始遍历，两者最终一定相等
        - 不相等期间如果 == null 说明到当前链表的末尾，则将其指针移动遍历另一条链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 判空
        if (headA == null || headB == null)
            return null;
        // 双指针
        ListNode p1 = headA;
        ListNode p2 = headB;

        // 利用 a + b = b + a，同时从 a b 开始遍历，两者最终一定相等
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
