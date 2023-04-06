package Top101.LinkedList;

import java.util.ArrayList;

public class BM13_IsPail {
    /*
        快慢指针找中点，然后反转后半个链表，快指针重新指向头部，再双指针遍历
        时间复杂度: O(n)，其中 n 为链表的长度，双指针找到中点遍历半个链表，
                   后续反转链表为 O(n)，然后再遍历两份半个链表
        空间复杂度: O(1)，常数级变量，没有额外辅助空间
     */
    public boolean isPail(ListNode head) {
        if (head == null)
            return true;
        ListNode slowP = head;
        ListNode fastP = head;
        // 快慢双指针找中点
        while (fastP != null && fastP.next != null) {
            slowP = slowP.next;
            fastP = fastP.next.next;
        }
        // 中点处 (slowP) 刚好指向后半段开头
        // 反转后半部分链表
        slowP = reverse(slowP);
        fastP = head;
        // 双指针遍历
        while (slowP != null) {
            if (slowP.val != fastP.val)
                return false;
            slowP = slowP.next;
            fastP = fastP.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /*
        先遍历一次链表存到数组中，双指针前后遍历数组
        时间复杂度: O(n)，其中 n 为链表的长度，遍历链表转化数组为 O(n)，双指针遍历半个数组为 O(n)
        空间复杂度: O(n)，记录链表元素的辅助数组
     */
    public boolean isPail_2(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int leftVal = nums.get(left);
            int rightVal = nums.get(right);
            if (leftVal != rightVal)
                return false;
            ++left;
            --right;
        }
        return true;
    }
}
