package round3.hot100.substr;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_239 {
    /*
        滑动窗口最大值
        1. 可以通过一个优先队列来维护窗口最大值，但每次只维护小于等于 k 个
        2. 优先队列定义
            保持队列头部元素为当前窗口的最大值
            - offer 如果当前元素比队列尾部元素要大，则将队列尾部元素弹出
            - poll 如果当前元素等于需要 poll 的元素时，推出，如果不是则无需操作
            - peek 返回队列头部元素
        3. 先扫描前 k 个，此时有队列头部为第一个最大值，这样可以无需每次在 for 内判断队列大小是否大于 k
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;

        // 定义优先队列，以及用于储存结果的数组
        MyQueue pq = new MyQueue();
        int[] res = new int[nums.length - k + 1];

        // 先放入 k 个到优先队列中
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        int index = 0;
        res[index++] = pq.peek();

        // 将剩余元素加入到优先队列中，类似于滑动窗口
        for (int i = k; i < nums.length; i++) {
            // 先尝试移除优先队列窗口中的左侧元素，再加入数组的元素到队列窗口中
            pq.poll(nums[i - k]);
            pq.offer(nums[i]);
            // 获取队列头，加入到结果中
            res[index++] = pq.peek();
        }
        return res;
    }
}

// 自定义优先队列
class MyQueue {
    /*
        保持队列头部元素为当前窗口的最大值
        - offer 如果当前元素比队列尾部元素要大，则将队列尾部元素弹出
        - poll 如果当前元素等于需要 poll 的元素时，推出，如果不是则无需操作
        - peek 返回队列头部元素
     */
    Deque<Integer> deque;

    public MyQueue() {
        this.deque = new LinkedList<>();
    }

    public void offer(int num) {
        // 维护单调性，保证队列头是最大元素
        while (!deque.isEmpty() && num > deque.peekLast())
            deque.pollLast();

        deque.offer(num);
    }

    // 如果当前元素等于需要 poll 的元素时，推出，如果不是则无需操作
    public void poll(int num) {
        if (!deque.isEmpty() && deque.peek() == num)
            deque.poll();
    }

    public int peek() {
        return deque.isEmpty() ? -1 : deque.peek();
    }
}
