package round4.leetcode.linkedlist;

public class ReverseKGroup_25 {
    /*
        K 个一组翻转链表
        1. 需要记录四个节点
           - 需要引入虚拟头节点
           - prev / next：被翻转链表部分的前一个节点和后一个节点
           - start / end: 被翻转链表的首个节点和尾部节点
        2. 当 end.next 不为空时，说明还有链表需要进行判断是否要翻转
           - 先初始化 start 节点，尝试向前遍历 k 次来更新 end 节点
                如果 end 为空，说明不足 k 个直接返回
           - 记录下 next 节点，准备断开链表，进行翻转
           - 翻转完成后，使用 prev.next 来接上翻转后的链表
           - start 变为尾部接上 next
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 判空
        if (head == null || head.next == null)
            return head;

        // 需要引入虚拟头节点，方便处理第一个节点被翻转
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 初始化 prev 和 end 节点，start 和 next 通过这两个节点获得
        ListNode prev = dummyHead;
        ListNode end = dummyHead;

        // 当 end.next 不为空时，说明还有链表需要进行判断是否要翻转
        while (end != null) {
            // 往前走 k 步更新 end 指针，为空则不够 k 个直接返回
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null)
                break;

            // 定义 start 和 next 节点
            ListNode start = prev.next;
            ListNode next = end.next;
            // 断开链表进行翻转，prev 接住翻转后的链表
            end.next = null;
            prev.next = reverseList(start);

            // start 翻转完之后变成尾部，和 next 连接上
            start.next = next;
            // 将 prev 和 end 更新到新的位置
            prev = start;
            end = start;
        }

        return dummyHead.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
