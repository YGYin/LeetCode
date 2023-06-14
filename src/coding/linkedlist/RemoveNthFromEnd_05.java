package coding.linkedlist;

public class RemoveNthFromEnd_05 {
    /*
        1. 快慢指针
        时间复杂度: O(n)
        空间复杂度: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode fastP = res;
        ListNode slowP = res;
        // 也可以让改为 i < n，循环条件改为 fastP.next != null
        // fastP 首先走 n + 1步
        // 只有这样同时移动的时候 slowP 才能指向删除节点的上一个节点，方便做删除操作
        for (int i = 0; i < n + 1; i++)
            fastP = fastP.next;

        while (fastP != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        slowP.next = slowP.next.next;

        return res.next;
    }
}
