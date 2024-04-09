package round1.hot100.linkedlist;

public class DetectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        // 与环形链表 1 不同的是，此处需要返回链表环的入口节点
        // 同样是快慢指针，在两个指针相遇之后，分别从头部和相遇处往前走
        // 第二次相遇的地方则为链表环入口节点
        // 2(x + y) = x + y + n(y + z)
        // let n = 1 -> x = z
        if (head == null)
            return null;
        ListNode slowP = head;
        ListNode fastP = head;
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
            if (slowP == fastP) {
                ListNode temp1 = head;
                ListNode temp2 = fastP;
                // 相遇之后，分别从头部和相遇处往前走一定在环入口处相遇
                while (temp1 != temp2) {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                return temp1;
            }
        }
        return null;
    }
}
