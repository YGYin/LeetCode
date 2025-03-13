package round4.leetcode.linkedlist;

public class MergeTwoLists_21 {
    /*
        合并两个有序链表
        1. 先判空，其中一个为空返回另外一个
        2. 通过虚拟头节点构造链表，当两个链表都不为空的时候，比较大小并接到构造链表上
        3. 出现其中一个为空，将另外一个链表剩余部分接上
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 判空
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        // 虚拟头节点构造目标链表，便于返回
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        // 两个同时不为空，比较大小接到目标链表上
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 移动目标链表指针
            cur = cur.next;
        }
        // 可能有两条链表长度不同，其中一条链表遍历到末尾的情况
        // 将剩余链表部份接到目标链表上
        cur.next = list1 == null ? list2 : list1;

        return dummyHead;
    }
}
