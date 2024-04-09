package round1.hot100.linkedlist;

public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        // 定义虚拟头节点方便构造链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 主要思想：用双指针遍历两个链表，较小的就接到新链表上去
        // 因为此处不需要再重新使用两个链表的头部，可以直接使用 list1 2 做指针
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 移动 cur
            cur = cur.next;
        }
        // 当其中一个指针已经遍历完后，将另外一条链表的剩余部份直接接到新链表上
        cur.next = list1 == null ? list2 : list1;
        // 最后返回虚拟头节点的下一节点
        return dummyHead.next;
    }
}
