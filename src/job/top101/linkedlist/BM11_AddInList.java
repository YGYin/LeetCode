package job.top101.linkedlist;

public class BM11_AddInList {
    /*
        因为正常运算是从低位到高位的运算，而链表遍历是从高位到低位
        所以应当先对链表进行反转，然后再遍历进行计算，计算完成后在再对答案链表反转
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // 得到反转之后的链表
        ListNode l1 = reverseList(head1);
        ListNode l2 = reverseList(head2);

        // 设置虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 获取 l1 l2 的节点的值
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;
            // 因为 l1 和 l2 可能有其一当前为空，移动指针前需特判
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 看最后 carry 位是否还有，有则加上
        if (carry > 0)
            cur.next = new ListNode(carry);

        // 反转链表
        return reverseList(dummyHead.next);
    }

    // 翻转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
