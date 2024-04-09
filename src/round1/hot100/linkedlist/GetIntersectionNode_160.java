package round1.hot100.linkedlist;

public class GetIntersectionNode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 判空
        if (headA == null || headB == null)
            return null;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        // ptrA: a + c1  ptrB: b + c2
        // a + c1 + b + c2 =  b + c2 + a + c1
        // 若 c1 c2 相等，那么在 c 起始处相遇，不相等则在 null 处相遇
        while (ptrA != ptrB) {
            ptrA = ptrA == null ? headB : ptrA.next;
            ptrB = ptrB == null ? headA : ptrB.next;
        }
        return ptrA;
    }
}
