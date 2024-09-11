package round2.hot100.linkedlist;

public class DetectCycle_142 {
    /*
        环形链表 II
        同样通过快慢指针，当快慢指针相遇后，
        再分别定义两个指针分别指向链表头和当前相遇元素，同时向前走，相遇处即为环入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;

            if (slowP == fastP) {
                // 相遇时定义指针分别指向链表头以及当前位置
                // 分别向前走
                ListNode p1 = fastP;
                ListNode p2 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                // 相遇处即为链表环入口
                return p1;
            }
        }
        return null;
    }
}