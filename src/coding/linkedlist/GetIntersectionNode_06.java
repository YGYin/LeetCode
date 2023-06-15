package coding.linkedlist;

public class GetIntersectionNode_06 {
    /*
        主要思想：将两个链表向右边对齐，让 curA 移动到和 curB 对齐的位置
        具体步骤：
            1. 求两个链表长度，为方便处理让 curA 和 lenA 为最长链表头和长度
            2. 求长度差，curA 移动长度差个节点，使得 curA 和 curB 对齐
            3. 遍历 curA 和 curB，遇到相同的节点返回

        时间复杂度: O(n + m)
        空间复杂度: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        // 获取两个链表的长度
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        // 让 curA 成为最长链表头
        if (lenB > lenA) {
            // swap(lenA, lenB)
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            // swap(curA, curB)
            ListNode tmpCur = curA;
            curA = curB;
            curB = tmpCur;
        }
        // 长度差
        int lenGap = lenA - lenB;
        // 让 curA 和 curB 指向同一个起点
        while (lenGap-- > 0)
            curA = curA.next;
        // 遍历 curA 和 curB，遇到相同的节点返回
        // 交点不是数值相等，是指针相等
        while (curA != null) {
            if (curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    private int getLen(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            ++count;
            cur = cur.next;
        }
        return count;
    }
}
