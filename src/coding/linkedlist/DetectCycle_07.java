package coding.linkedlist;

public class DetectCycle_07 {
    /*
        快慢指针法：快慢指针相遇后，再分别用指针分别指向相遇处和链表头部
                   两个分别往前遍历，相遇即为入口处
                   2 (x + y) = x + y + n(y + z)
                -> x = n(y + z) - y
                -> x = (n - 1)(y + z) + z
                -> x = z

        时间复杂度: O(n)，快慢指针相遇前，指针走的次数小于链表长度，
                         快慢指针相遇后，两个index指针走的次数也小于链表长度，
                         总体为走的次数小于 2n
        空间复杂度: O(1)

     */
    public ListNode detectCycle(ListNode head) {
        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            // 有环
            if (slowP == fastP) {
                ListNode ptr1 = fastP;
                ListNode ptr2 = head;
                // x = z
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }
        return null;
    }
}
