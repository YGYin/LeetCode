package round4.leetcode.linkedlist;

public class IssPalindrome_234 {
    /*
        回文链表
        要求在 O(1) 空间实现，O(n) 时间复杂度
        1. 先求链表的中点
        2. 翻转后半部份的链表
        3. 遍历进行比较这两部份的链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        // 求链表中点，并翻转后半部份链表
        ListNode mid = getMidNode(head);
        ListNode head2 = reverseList(mid);

        // 遍历过程不需要回头，可以不额外定义指针
        // 因为原来链表的指向关系未变，mid 仍然是可访达的原链表中点
        while (head != mid) {
            if (head.val != head2.val)
                return false;
            else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    // 通过快慢指针找中点，奇数时为中点，偶数时为后半部份第一个节点
    private ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
