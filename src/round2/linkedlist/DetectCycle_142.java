package round2.linkedlist;

public class DetectCycle_142 {
    /*
        环形链表 II
        快慢指针，当遇到相同的节点后
        分别从头部和当前位置往前各走一步，节点相同处就为环形链表的入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            // 若快慢指针相遇
            if (slowP == fastP) {
                // 另外定义指针分别指向头部和当前位置
                ListNode ptr1 = head;
                ListNode ptr2 = fastP;
                // 在相等前各走一步
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
