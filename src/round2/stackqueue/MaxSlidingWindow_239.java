package round2.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_239 {

    /*
        滑动窗口最大值
        可以维护一个单调队列，实现 peek() offerLast() pollFirst() 并遵守以下规则
        - pollFirst(val): 看当前 poll 的元素是否为队首元素，是则 poll，不是则不操作
        - offerLast(val): 为了保持单调队列，将入口处小于 val 的全部弹出
        - peek() 队首始终保持当前窗口的最大元素
        该队列最多维护 k 个元素，但实际上没有必要维护窗口里的所有元素，
        只需要维护有可能成为窗口里最大值的元素就可以了，同时保证队列里的元素数值是由大到小的。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        // 定义储存数组的长度
        int[] res = new int[nums.length - k + 1];
        // 初始化单调队列，将前 k 个元素加入到队列中
        MyDeque deque = new MyDeque();
        for (int i = 0; i < k; i++)
            deque.offerLast(nums[i]);
        // 放入第一个最大值
        int count = 0;
        res[count++] = deque.peek();
        // 从 k 开始
        for (int i = k; i < nums.length; i++) {
            // 先移除窗口最前面的元素
            deque.pollFirst(nums[i - k]);
            // 再添加窗口最右边元素
            deque.offerLast(nums[i]);
            // 当前窗口最大值加入到 res 中
            res[count++] = deque.peek();
        }

        return res;
    }

}

class MyDeque {
    Deque<Integer> deque = new LinkedList<>();

    // 为了保持单调队列，将入口处小于 val 的全部弹出
    void offerLast(int val) {
        while (!deque.isEmpty() && val > deque.peekLast())
            deque.pollLast();

        deque.offerLast(val);
    }

    // 看当前 poll 的元素是否为队首元素，是则 poll，不是则不操作
    void pollFirst(int val) {
        if (!deque.isEmpty() && val == deque.peekFirst())
            deque.pollFirst();
    }

    int peek() {
        return deque.peek();
    }
}

