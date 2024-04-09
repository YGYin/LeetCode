package round1.hot100.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsPalindrome_234 {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;
        // 判断是否回文链表，开一个 list 存，转为数组双指针判断是否回文
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            // list 里面为包装类 Integer，要用 equals 比较是否相等
            if (!list.get(start).equals(list.get(end)))
                return false;
            ++start;
            --end;
        }
        return true;
    }
}
