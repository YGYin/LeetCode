package Top101.LinkedList;

public class BM3_ReverseKGroup {
    /*
    step 1：每次从进入函数的头节点优先遍历链表k次，分出一组，若是后续不足k个节点，不用反转直接返回头。
    step 2：从进入函数的头节点开始，依次反转接下来的一组链表，反转过程同BM1.反转链表。
    step 3：这一组经过反转后，原来的头变成了尾，后面接下一组的反转结果，下一组采用上述递归继续。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;
        // 找到每次翻转的尾部，即下一组的开头第一个元素
        ListNode tail = head;
        // 遍历 k 个节点到当前组的尾部
        for (int i = 0; i < k; i++) {
            // 如果该组不足 k 个就到了链表尾，直接返回不用翻转
            if (tail == null)
                return head;
            tail = tail.next;
        }
        // 记录翻转所需的前序和当前节点
        ListNode pre = null;
        ListNode cur = head;

        while (cur != tail) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        // 翻转后 head 为当前组的最后一个节点，当前尾部指向下一段要翻转的链表
        head.next = reverseKGroup(tail, k);
        return pre;
    }
}
