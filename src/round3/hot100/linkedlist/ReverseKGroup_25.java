package round3.hot100.linkedlist;

import round2.monostack.NextGreaterElement_496;

public class ReverseKGroup_25 {
    /*
        K 个一组翻转链表
        1. 需要记录四个节点
           - 需要引入虚拟头节点
           - prev / next：被翻转链表部分的前一个节点和后一个节点
           - start / end: 被翻转链表的首个节点和尾部节点
        2. 当 end.next 不为空时
           - 先初始化 start 节点，尝试遍历 k 次来更新 end 节点
                如果 end 为空，说明不足 k 个直接返回
           - 记录下 next 节点，准备断开链表，进行翻转
           - 翻转完成后，使用 prev.next 来接上翻转后的链表
           - start 变为尾部接上 next
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判空
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 初始化 pre 以及 end 节点
        ListNode prev = dummyHead;
        ListNode end = dummyHead;

        // 当 end.next 不等于空，说明还有链表需要进行判断是否要翻转
        while (end.next != null) {
            // 初始化 start
            ListNode start = prev.next;
            // 遍历 k 次
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            // 如果 end 为空，说明剩余节点不足 k 个，直接 break 返回
            if (end == null)
                break;

            // 记录 next 节点，并断开链表进行翻转
            ListNode next = end.next;
            end.next = null;
            // 翻转链表，用 pre 接住
            prev.next = reverseList(start);

            // 翻转完成后，start 已经指向翻转后链表的末尾，连接上 next
            start.next = next;
            // 更新 prev 和 end 指针
            prev = start;
            end = start;
        }

        return dummyHead.next;
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
}
