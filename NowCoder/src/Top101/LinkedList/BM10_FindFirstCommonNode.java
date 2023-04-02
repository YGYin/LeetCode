package Top101.LinkedList;

public class BM10_FindFirstCommonNode {
    /*
        让两个指针一起遍历
        1. 当 ptr1 先走完链表 1 的尽头的时候，则从链表 2 的头节点继续遍历
        2. ptr2同理
        因为两个指针，同样的速度，走完同样长度 (链表 1 + 链表 2)
        不管两条链表有无相同节点，都能够到达同时到达公共点或者终点。
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode ptr1 = pHead1;
        ListNode ptr2 = pHead2;
        while (ptr1 != ptr2) {
            ptr1 = (ptr1 == null) ? pHead2 : ptr1.next;
            ptr2 = (ptr2 == null) ? pHead1 : ptr2.next;
        }
        return ptr1;
    }
}
