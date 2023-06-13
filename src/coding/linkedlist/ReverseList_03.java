package coding.linkedlist;

public class ReverseList_03 {
    /*
        1. 双指针反转
        时间复杂度: O(n)
        空间复杂度: O(1)
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode pre = null;
        // 用于保存 cur 下一节点
        ListNode temp;
        while (cur != null) {
            // 先保存当前的下一节点，因为接下来要将 cur.next 指向 pre
            temp = cur.next;
            cur.next = pre;
            // 更新 pre 和 cur 指针
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /*
        2. 递归
        和双指针法是一样的逻辑，同样是当cur为空的时候循环结束，不断将cur指向pre的过程

        时间复杂度: O(n)
        空间复杂度: O(n)
     */
    public ListNode reverseList_2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
}
