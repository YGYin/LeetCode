package job.top101.linkedlist;

public class BM14_OddEvenList {
    /*
        将链表的奇数位节点编号和偶数位节点编号分别放在一起，重排后输出
        注意是节点的编号而非节点的数值
        可以新建偶数链表头，分别记录奇数位置和偶数位置，最后将偶数连接到奇数后面
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 新建奇数指针，以及偶数链表头和偶数指针
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            // 下一个奇数位置在当前偶数后面，更新指针
            odd.next = even.next;
            odd = odd.next;
            // 更新偶数
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
