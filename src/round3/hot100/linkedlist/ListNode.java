package round3.hot100.linkedlist;

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

    public ListNode(int val, ListNode prev, ListNode next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
