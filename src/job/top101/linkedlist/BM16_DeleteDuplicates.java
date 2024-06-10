package job.top101.linkedlist;

public class BM16_DeleteDuplicates {
    /*
        删除有序链表中重复的元素-II
        给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        // 要取 cur.next.next 的 val，要保证 cur.next.next 也不为空
        while (cur.next != null && cur.next.next != null) {
            // 当前位置后面两个相邻的节点值相等
            if (cur.next.val == cur.next.next.val) {
                // 相等缓存该值，并跳过后面所有相同的节点
                int tempVal = cur.next.val;
                // 当下一个节点不为空，且下一个节点为相同值时
                // 因为此处只需要去 cur.next 的 val，只需要保证 cur.next != null
                while (cur.next != null && cur.next.val == tempVal)
                    cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        return dummyHead.next;
    }
}
