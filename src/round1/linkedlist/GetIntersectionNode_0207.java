package round1.linkedlist;

public class GetIntersectionNode_0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 找两个链表是否相交并返回相交的起始节点
        // 本质为两个链表向右对齐，比较找到第一个相同的节点
        // 求出两个链表长度差值，curA 移动到和 curB 末尾对齐的位置
        // 然后比较 curA 和 curB 是否相同，不相同则同时向后移动
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        // 统计 A B 链表长度，求出两个链表长度差值
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // 重置指针位置指向头部
        curA = headA;
        curB = headB;
        // 手动让 curA 为最长链表的头
        if (lenB > lenA) {
            // 交换 lenA 和 lenB
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;
            // 互换 curA 和 curB
            ListNode tempNode = curA;
            curA = curB;
            curB = tempNode;
        }
        // A B 指针对齐
        int offset = lenA - lenB;
        for (int i = 0; i < offset; i++)
            curA = curA.next;
        // 遍历 A B 遇到相同就返回
        while (curA != null) {
            if (curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
