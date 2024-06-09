package job.top101.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class BM13_IsPail {
    public boolean isPail(ListNode head) {
        if (head == null || head.next == null)
            return true;

        List<Integer> list = new ArrayList<>();
        // 遍历链表，存到 list 中再转化为数组
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right)
            if (!list.get(left++).equals(list.get(right--)))
                return false;

        return true;
    }
}
