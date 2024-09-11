package round2.hot100.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        // 定义 list 遍历链表储存元素，再用双指针
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right)))
                return false;
            ++left;
            --right;
        }

        return true;
    }
}
