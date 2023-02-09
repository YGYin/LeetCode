package ds_primer;

public class RemoveElements_203 {
    // 迭代
    public ListNode removeElements(ListNode head, int val) {
        // 新建虚拟头节点，指向对应链表的头节点
        ListNode res = new ListNode();
        res.next = head;
        ListNode temp = res;
        while (temp.next != null) {
            if (temp.next.val == val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return res.next;
    }

    //递归
    public ListNode removeElements_2(ListNode head, int val) {
        if (head == null)
            return head;
        head.next = removeElements_2(head.next, val);
        return head.val == val ? head.next : head;
    }
}
