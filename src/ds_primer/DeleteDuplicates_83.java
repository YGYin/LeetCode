package ds_primer;

import java.util.HashSet;

public class DeleteDuplicates_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        HashSet<Integer> set = new HashSet<>();
        set.add(curr.val);

        while (curr.next != null) {
            if (!set.add(curr.next.val))
                // point to next node
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        return head;
    }

    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val)
                // point to next node
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        return head;
    }
}
