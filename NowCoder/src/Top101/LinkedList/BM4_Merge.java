package Top101.LinkedList;

public class BM4_Merge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode res = new ListNode(0);
        ListNode cur = res;

        while (list1 != null && list2 != null) {
            // 取较小值的节点
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // 指针后移
            cur = cur.next;
        }
        // 看如果有链表有剩余，直接连在后面
        if (list1 != null)
            cur.next = list1;
        else
            cur.next = list2;

        return res.next;
    }
}
