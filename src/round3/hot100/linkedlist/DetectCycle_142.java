package round3.hot100.linkedlist;

public class DetectCycle_142 {
    /*
        环形链表 II
        同样通过快慢指针，当快慢指针相遇后，
        再分别定义两个指针分别指向链表头和当前相遇元素，同时向前走，相遇处即为环入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 相等时，分别定义两个指针指向链表头和相等处分别往前走
                ListNode p1 = head;
                ListNode p2 = fast;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                // 相等处为链表入口
                return p1;
            }
        }
        return null;
    }
}
