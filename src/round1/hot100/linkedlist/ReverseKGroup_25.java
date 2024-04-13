package round1.hot100.linkedlist;

public class ReverseKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // k 个一组反转链表
        /*
            将链表划分为已翻转，待翻转和未翻转
            start 为待翻转的首个节点，end 为待翻转的最后一个节点
            pre 指向待翻转的节点前一个节点，next 为 end 下一个节点
            1. 从 pre 开始遍历 k 次，记录好四个指针，end 处断开链表，翻转
            2. 翻转完成后 start 到尾部，将其与 next 连接并且更新 pre
            3. end 要重置到 pre 的位置，为了下次再遍历 k
         */
        // 判空
        if (head == null || head.next == null)
            return head;
        // 定义虚拟头节点方便遍历
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 定义 pre 和 end 指针
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        // 当需要翻转的链表尾部下一节点不为空
        while (end.next != null) {
            // 遍历 k 次，要注意同时保持 end 不为空
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            // end 为空说明不够 k 个，直接返回
            if (end == null)
                break;

            // 到尾部之后记录下 未翻转链表 的头节点，并断开链表准备翻转
            ListNode next = end.next;
            end.next = null;
            // 记录 start 指针
            ListNode start = pre.next;
            // 反转链表，传入待翻转链表的头节点，翻转后接上 pre
            pre.next = reverseList(start);

            // 翻转完成后，start 位于尾部，需要连接未翻转的链表
            start.next = next;
            // 同时更新 pre 和 end 指针到当前尾部（下一个链表的开头，即 start）
            pre = start;
            end = start;
        }
        return dummyHead.next;
    }

    // 翻转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode nextTemp = null;
        while (cur != null) {
            // 因为要断开 cur 和下一个节点的连接，需要先记录下一个节点
            nextTemp = cur.next;
            // 将指针往回指向 pre
            cur.next = pre;
            // 更新 pre 和 cur 指针
            pre = cur;
            cur = nextTemp;
        }
        return pre;
    }
}
