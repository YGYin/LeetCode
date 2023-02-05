package ds_primer;

public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode ptr1 = list1, ptr2 = list2;

        ListNode res = new ListNode();
        ListNode temp = res;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                temp.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
            } else {
                temp.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
            }
            temp = temp.next;
        }

        if (ptr1 == null)
            temp.next = ptr2;

        if (ptr2 == null)
            temp.next = ptr1;

        return res.next;
    }
}
