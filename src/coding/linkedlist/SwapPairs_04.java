package coding.linkedlist;

public class SwapPairs_04 {
    /*
        1. 先用虚拟头节点，翻转第第二个

     */
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = head;
        // temp 坐临时节点用于保存两个节点后面的节点
        ListNode temp, firstNode, secondNode;
        while (cur.next != null || cur.next.next != null) {
            firstNode = cur.next;
            secondNode = cur.next.next;
            temp = cur.next.next.next;
            // 当前节点指向第二个节点
            cur.next = secondNode;
            // 第二节点指回第一节点
            secondNode.next = firstNode;
            // 第一节点指向第三个节点
            firstNode.next = temp;
            // 更新 cur 位置
            cur = firstNode;
        }
        return res.next;
    }

    /*
        2. 递归
     */
    public ListNode swapPairs_2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        ListNode newNode = swapPairs_2(next);
        next.next = head;
        head.next = newNode;

        return next;
    }
}
