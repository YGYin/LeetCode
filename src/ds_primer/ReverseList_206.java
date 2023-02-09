package ds_primer;

import java.util.ArrayList;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 先遍历一次链表，装到对应arraylist中，再倒过来遍历arraylist加入到新链表中
        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        ListNode res = new ListNode();
        ListNode ptr;
        ptr = res;
        for (int i = list.size() - 1; i >= 0; --i) {
            ptr.next = new ListNode(list.get(i));
        }

        return res.next;
    }

    public ListNode reverseList_2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        new ReverseList_206().reverseList(head);
    }
}
