
package round4.leetcode.linkedlist;

public class SortList_148 {
    /*
        排序链表 (找链表偏左的中点 + 合并两个有序链表)
        主要分为两步：
        1. 找到链表的中点，断开为左右链表，
            然后后序遍历递归切割左右链表，中间操作为合并为有序链表
        2. 合并链表操作和合并两条有序链表操作相同
     */
    public ListNode sortList(ListNode head) {
        // 判空
        if (head == null || head.next == null)
            return head;

        // 找到链表偏左的中点，便于断开链表为左右链表分开归并排序
        ListNode midNode = getMidNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;

        // 分别递归断开左右链表，最后再合并两个有序链表
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(rightHead);

        return mergeTwoLists(leftList, rightList);
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 判空
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 虚拟头节点构建目标链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 两条链表同时不为空则遍历
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
        // 有可能其中一条为空，将剩余链表部份接到目标链表
        cur.next = l1 == null ? l2 : l1;
        // 返回构造好的目标链表
        return dummyHead.next;
    }

    // 找链表偏左的中点
    private ListNode getMidNode(ListNode head) {
        // 判空
        if (head == null || head.next == null)
            return head;

        // 定义快慢指针找中点，因为为偏左中点，先让快指针走两步
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
