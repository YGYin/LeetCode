package round2.hot100.linkedlist;

public class AddTwoNumbers_2 {
    /*
        两数相加
        因为两个链表本身以逆序储存元素，分别遍历两条链表，当前位置直接相加，
        同时使用虚拟头构建链表
        但需要储存进位，统一向后进位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        // 在外面定义 carry
        int carry = 0;
        // 当两条链表不都为空时
        // 因为有可能长度不同一条先为空
        while (l1 != null || l2 != null) {
            // 分别取两个链表当前节点的值，有可能为空
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            // 加和，更新 carry，sum 记得 mod 10 变为个位数
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;

            // 将 sum 构造节点存到目标链表中
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 如果不为空则移动指针
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 记得可能最后有可能还有 carry 进位
        if (carry != 0)
            cur.next = new ListNode(carry);

        return dummyHead.next;
    }
}
