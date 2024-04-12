package round1.hot100.linkedlist;

public class SortList_148 {
    // 核心思想：通过后续遍历递归进行归并排序，每次找到当前链表中点，
    //          从中点把链表断开，并递归下探
    // 1. 返回排序好的链表，传入头节点
    public ListNode sortList(ListNode head) {
        // 2. 当头部本身为空或者递归到不能再切割时返回头部
        if (head == null || head.next == null)
            return head;
        // 找到当前链表中点，因为快指针先走两部，该中点偏左
        ListNode midNode = getMidNode(head);
        // 记录当前下一个节点为右链表的链表头，断开左右链表
        ListNode rightHead = midNode.next;
        midNode.next = null;

        // 进行递归下探切割链表，左右，最后中合并链表
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(rightHead);
        // 中：后续遍历最后再合并成有序链表
        return mergeTwoList(leftList, rightList);
    }

    // 876. 链表的中间节点
    private ListNode getMidNode(ListNode head) {
        // 判空
        if (head == null || head.next == null)
            return head;
        // 双指针，先让快指针走两步
        ListNode slowP = head;
        ListNode fastP = head.next.next;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;
    }

    // 21. 合并两个有序链表
    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        // 定义虚拟头节点方便构建链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 当两链表同时不为空时
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 最后可能有其中一条链表不为空或者全为空
        cur.next = l1 != null ? l1 : l2;

        return dummyHead.next;
    }
}
