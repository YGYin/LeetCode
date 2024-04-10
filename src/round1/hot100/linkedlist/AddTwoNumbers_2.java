package round1.hot100.linkedlist;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 两数相加，每位数字都是按照 逆序 的方式存储的
        // 将链表左对齐分别开始遍历，进位向后一位 + 1
        // 直接使用链表本身不需要额外定义双指针

        // 定义虚拟头节点方便返回，定义 carry 进位，以及指针创建新链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carry = 0;

        // 当两条链表其中一条未遍历完
        while (l1 != null || l2 != null) {
            // 有可能其中链表为空，补 0
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            // 两值加上 carry 位
            int sum = val1 + val2 + carry;
            // 处理 sum，检查是否要进位，同时取模
            carry = sum / 10;
            sum %= 10;

            // 新建节点，连接链表，移动指针
            cur.next = new ListNode(sum);
            cur = cur.next;
            // 移动 l1 l2 指针
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 有可能最后相加有进位，将 carry 位进 1 新增节点添加到链表尾部
        if (carry == 1)
            cur.next = new ListNode(carry);

        return dummyHead.next;
    }
}
