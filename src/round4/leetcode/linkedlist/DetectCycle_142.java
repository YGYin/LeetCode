package round4.leetcode.linkedlist;

public class DetectCycle_142 {
    /*
        环形链表 II
        同样通过快慢指针，当快慢指针相遇后，
        再分别定义两个指针分别指向链表头和当前相遇元素，同时向前走，相遇处即为环入口
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        // 定义快慢指针，先让快慢指针相遇
        ListNode slow = head;
        ListNode fast = head;
        // 有可能存在没有环的情况，所以循环结束条件依然以快指针判空为标准
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // 找到相同节点后
            if (slow == fast) {
                // 两个指针分别指向链表头和当前相遇元素，同时向前走，相遇处即为环入口
                ListNode p1 = head;
                ListNode p2 = slow;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
