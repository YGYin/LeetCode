package job.top101.linkedlist;

public class BM12_SortInList {
    /*
        单链表排序
        通过递归实现归并排序
        1. 分割 cut: 通过快慢指针找到链表中点，从中点将链表断开，
            当 cur.next == null 时，说明只有一个节点了，直接返回该节点
        2. 合并 merge: 将两个排序链表合并，转化为一个排序链表，
            新建节点作为头部，用双指针分别指向两链表头部，比较大小，从小到大合并

     */
    public ListNode sortInList(ListNode head) {
        // 先判断当前节点或下一节点是否为空
        if (head == null || head.next == null)
            return head;
        // 定义快慢指针来寻找链表中点
        ListNode slowP = head;
        ListNode fastP = head.next;
        // slowP 为链表中点
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        // 记录下一个链表的首个节点，并断开链表
        ListNode temp = slowP.next;
        slowP.next = null;
        // 递归左右两边进行排序
        ListNode left = sortInList(head);
        ListNode right = sortInList(temp);
        // 虚拟头节点，用于新建链表
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        // 合并左右链表
        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        // 可能有一个链表没空
        cur.next = left == null ? right : left;
        return dummyHead.next;
    }
}
