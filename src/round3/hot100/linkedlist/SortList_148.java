package round3.hot100.linkedlist;

import java.util.Currency;

public class SortList_148 {
    /*
        排序链表
        主要分为两步：
        1. 找到链表的中点，断开为左右链表，
            然后后序遍历递归切割左右链表，中间操作为合并为有序链表
        2. 合并链表操作和合并两条有序链表操作相同
     */
    public ListNode sortList(ListNode head) {
        // 先特判
        if (head == null || head.next == null)
            return head;

        // 找到链表中点（偏左）
        ListNode midNode = getMidNode(head);
        // 断开链表为左右链表
        ListNode rightHead = midNode.next;
        midNode.next = null;

        // 递归切分左右链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        // 返回合并的有序链表
        return mergeList(left, right);
    }

    // 合并两个有序链表
    private ListNode mergeList(ListNode l1, ListNode l2) {
        // 先对两条链表分别判空
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 需要定义虚拟头节点和指针来构造有序链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 当两条链表完全不为空时才进行值的比较
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // 移动指针
            cur = cur.next;
        }

        // 将链表剩余部分接到新链表上
        cur.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

    // 快慢指针找链表中点
    private ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 定义快慢指针，慢指针指向头部，快指针先走两步
        ListNode slowP = head;
        ListNode fastP = head.next.next;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;
    }
}
