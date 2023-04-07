package Top101.LinkedList;

public class BM14_OddEvenList {
    /*
        第一个节点是奇数位，第二个节点是偶数，第二个节点后又是奇数位
        因此可以断掉节点1和节点2之间的连接，指向节点2的后面即节点3，如红色箭头
        如果此时我们将第一个节点指向第三个节点，就可以得到那么第三个节点后为偶数节点
        因此我们又可以断掉节点2到节点3之间的连接，指向节点3后一个节点即节点4
        那么我们再将第二个节点指向第四个节点，又回到刚刚到情况了

        时间复杂度: O(n)，遍历一次链表的所有节点
        空间复杂度: O(1)，常数级指针，无额外辅助空间
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // odd 指向首节点，even 指向第二个节点
        ListNode odd = head;
        ListNode even = head.next;
        // 奇数结束后偶数接在后面，需要偶数链表头
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            // odd 连接 even 后一个
            odd.next = even.next;
            // 移动 odd 指针，even 同理
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 将 evenHead 接在 odd 后面
        odd.next = evenHead;
        return head;
    }
}
