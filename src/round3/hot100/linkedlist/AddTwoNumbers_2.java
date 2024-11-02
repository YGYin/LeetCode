package round3.hot100.linkedlist;

public class AddTwoNumbers_2 {
    /*
        两数相加
        因为两个链表本身以逆序储存元素，分别遍历两条链表，当前位置直接相加，
        同时使用虚拟头构建链表
        但需要储存进位，统一向后进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为两条链表至少都有一个节点，无需判空
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        int carry = 0;
        // 两个链表的长度可能不相同
        while (l1 != null || l2 != null) {
            // 先取两个节点的值，如果为空则为 0
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            // 记得加上进位
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 避免操作空指针
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 最后可能还有进位需要相加
        if (carry != 0)
            cur.next = new ListNode(carry);

        return dummyHead.next;
    }
}
