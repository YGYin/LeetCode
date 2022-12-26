package offer;

import java.util.ArrayList;

public class ReversePrint_06 {
    public int[] reversePrint(ListNode head) {
        // Scan to get the length, then create the array and add it
        if (head == null)
            return new int[]{};
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            ++count;
            temp = temp.next;
        }
        int[] nums = new int[count];
        temp = head;
        for (int i = count - 1; i >= 0; --i) {
            nums[i] = temp.val;
            temp = temp.next;
        }
        return nums;
    }
}
