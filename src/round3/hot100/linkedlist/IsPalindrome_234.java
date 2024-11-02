package round3.hot100.linkedlist;

public class IsPalindrome_234 {
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

        // 先求当前链表的中点
        ListNode mid = getMid(head);
        // 再翻转后半部份的链表
        ListNode head2 = reverseList(mid);

        // 遍历链表，因为原链表的指向关系没有变，所以 mid 仍然为原来链表的中点
        while (head != mid) {
            // 比较 head1 和 head2
            if (head.val != head2.val)
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 快慢指针求链表的中点
    // 链表为奇数，指向中点；链表为偶数，指向后半部份的第一个节点
    private ListNode getMid(ListNode head) {
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;

        // fast 每次走两步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
