package coding.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_06 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        int resLen = nums.length - k + 1;
        int[] res = new int[resLen];
        MonoQueue myQueue = new MonoQueue();

        // 将前 k 个元素加入到队列中
        for (int i = 0; i < k; i++)
            myQueue.add(nums[i]);
        // 将当前第一个窗口中的最大值加入 res 数组
        int count = 0;
        res[count++] = myQueue.peekMax();

        // 开始滑动窗口
        for (int i = k; i < nums.length; i++) {
            // 滑动窗口移除窗口最前面的元素，起到判断该元素是否被放入
            myQueue.poll(nums[i - k]);
            // 加入下一个元素
            myQueue.add(nums[i]);
            // 将当前窗口最大值加入 res 数组
            res[count++] = myQueue.peekMax();
        }
        return res;
    }
}

class MonoQueue {
    Deque<Integer> deque = new LinkedList<>();

    // 弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek())
            deque.poll();
    }

    /*
        添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        保证队列元素单调递减
        比如此时队列元素3 1，2将要入队，比1大，所以1弹出，此时队列：3,2
     */
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast())
            deque.removeLast();

        deque.add(val);
    }

    // 维护队列队顶元素始终为最大值
    int peekMax() {
        return deque.peek();
    }
}
