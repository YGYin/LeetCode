package round2.hot100.linkedlist;

public class MergeTwoLists_21 {
    /*
        1. 新建链表头构造链表
        2. 用双指针分别遍历两个链表，较小的节点接到目标链表
            - 本质可以不需要新建指针，直接用原来两个链表的链表头
        3. 当其中一个为空的时候，将另外一个链表剩余部分直接接到目标链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        // 新建虚拟头节点构造链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        // 两条链表同时不为空时进行比较
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 更新指针
            cur = cur.next;
        }
        // 有其中一条链表或者两条链表都为空，将剩余部分接到目标链表上
        cur.next = list1 == null ? list2 : list1;

        return dummyHead.next;
    }
}
