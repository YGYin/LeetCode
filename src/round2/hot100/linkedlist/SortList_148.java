package round2.hot100.linkedlist;

public class SortList_148 {
    /*
     * 排序链表
     * 主要分为两步：
     * 1. 找到链表的中点，断开为左右链表，
     * 然后后序遍历递归切割左右链表，中间操作为合并为有序链表
     * 2. 合并链表操作和合并两条有序链表操作相同
     */
    public ListNode sortList(ListNode head) {
        // 先判空
        if (head == null || head.next == null)
            return head;

        // 找到链表的中点
        ListNode midNode = getMidNode(head);
        // 断开链表为左右两段链表
        ListNode rightHead = midNode.next;
        midNode.next = null;

        // 递归继续切分左右链表
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);
        // 最后返回排序好的链表
        return mergeList(left, right);
    }

    // 通过快慢指针获得当前链表的中间节点，记得要先让快指针先走两步
    ListNode getMidNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // ! 需要让快指针先走两步
        ListNode slowP = head;
        ListNode fastP = head.next.next;

        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }

        return slowP;
    }

    // 合并两个有序链表
    ListNode mergeList(ListNode l1, ListNode l2) {
        // 判空
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        // 新建链表头构造链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 为同时不为空，当为空时将剩余一条接上
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            // 更新 cur 指针
            cur = cur.next;
        }
        // 剩余部分接上目标链表
        cur.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}
