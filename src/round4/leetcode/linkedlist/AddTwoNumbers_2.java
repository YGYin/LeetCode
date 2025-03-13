package round4.leetcode.linkedlist;

public class AddTwoNumbers_2 {
    /*
        两数相加
        因为两个链表本身以逆序储存元素，分别遍历两条链表，当前位置直接相加，
        同时使用虚拟头构建链表
        但需要储存进位，统一向后进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 特判
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 虚拟头节点构造链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 储存进位
        int carry = 0;

        // 只要其中一条链表不为空则继续遍历
        while (l1 != null || l2 != null) {
            // 长度不同已经为空的情况下则该节点的值为 0
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            // 记录进位
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;

            // 构造节点加到目标链表中，移动指针
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 不为空则移动两个链表的指针
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 有可能进位不为 0，需要再构造一个节点加入到目标链表中
        if (carry != 0)
            cur.next = new ListNode(carry);

        return dummyHead.next;
    }
}
