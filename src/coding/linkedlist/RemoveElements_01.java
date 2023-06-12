package coding.linkedlist;

public class RemoveElements_01 {
    /*
        因为可能需要移除头节点，设置一个虚拟头结点再进行移除节点操作

        时间复杂度: O(n)
        空间复杂度: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        // 新建虚拟头节点，指向对应链表头节点
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        // 循环判断下一个节点是否为空
        while (cur.next != null) {
            if (cur.next.val == val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return res.next;
    }
}
