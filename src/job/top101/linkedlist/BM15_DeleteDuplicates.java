package job.top101.linkedlist;

public class BM15_DeleteDuplicates {
    /*
        删除有序链表中重复的元素-I
        遍历链表，如果当前节点值和下一个节点的值相同，跳过下一个节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 判空
        if (head == null)
            return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}
