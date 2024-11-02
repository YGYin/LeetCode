package round3.hot100.linkedlist;

public class MergeTwoLists_21 {
    /*
        合并两个有序链表
        1. 先判空，其中一个为空返回另外一个
        2. 通过虚拟头节点构造链表，当两个链表都不为空的时候，比较大小并接到构造链表上
        3. 出现其中一个为空，将另外一个链表剩余部分接上
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        // 虚拟头节点构造链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 将剩余部分接到链表上
        cur.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }
}
