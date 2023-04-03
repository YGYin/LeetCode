package Top101.LinkedList;

public class BM11_AddInList {
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        // 反转两个链表，即将链表向左对齐
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        // 新建链表记录答案
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            // 链表不为空直接取该值
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            // 相加得到当前位置的值
            int tempVal = val1 + val2 + carry;
            // 获取进位，进位后取10的模
            carry = tempVal / 10;
            tempVal %= 10;
            // 新链表新增节点
            cur.next = new ListNode(tempVal);
            cur = cur.next;
            // 两个链表分别往前移动
            if (head1 != null)
                head1 = head1.next;
            if (head2 != null)
                head2 = head2.next;
        }
        return reverseList(res.next);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
