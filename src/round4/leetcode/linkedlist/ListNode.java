package round4.leetcode.linkedlist;

public class ListNode {

    int val;
    ListNode prev;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode next, ListNode prev, int val) {
        this.next = next;
        this.prev = prev;
        this.val = val;
    }
}
