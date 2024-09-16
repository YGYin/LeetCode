package round2.hot100.linkedlist;

public class ReverseKGroup_25 {
    /*
        K 个一组翻转链表
        主要思想
        1. 需要虚拟头节点，同时记录四个节点，
        pre: 翻转的链表的前一个节点 start / end: 翻转链表的首尾节点
        next: 记录 end 的下一个节点，翻转前 end 末端需要先断开连接
        2. 翻转完成后，start 节点已经变成尾部，再通过 start 连接 next
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        // 定义虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 此处需要先初始化 pre 和 end 指针，end 作为循环判空条件
        ListNode pre = dummyHead;
        ListNode end = dummyHead;
        // 当 end 的下一个节点不为空，即下次要被翻转第一个节点
        while (end.next != null) {
            // 初始化 start 节点
            ListNode start = pre.next;
            // 遍历 k 次移动 end 指针到当前要翻转链表的末尾
            // 同时要保持 end 不为空
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null)
                break;

            // 记录 next 节点
            ListNode next = end.next;
            // 断开要翻转的链表的末端
            end.next = null;
            // 翻转当前链表，返回当转后的头节点
            pre.next = reverseList(start);

            // 翻转完成后，start 指向的节点已经变为链表末端，连接上 next
            start.next = next;
            // 更新 pre 和 end 到待翻转链表的前一个节点，即 start
            pre = start;
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
            // 记录 当前节点的下一个节点
            ListNode temp = cur.next;
            // 指针掉转方向指向前一个节点
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
