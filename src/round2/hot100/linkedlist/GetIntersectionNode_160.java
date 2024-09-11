package round2.hot100.linkedlist;


public class GetIntersectionNode_160 {
    /*
     * 相交链表
     * a + b = b + a
     * 1. 双指针分别开始遍历，先遍历自己链表再遍历对方链表
     * 2. 当节点不相等，为空说明当前链表到末尾，则去遍历对方链表
     * 3. 因为长度相等，最终两个指针一定相等，有可能指向末尾或者相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
