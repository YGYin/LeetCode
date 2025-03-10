package round4.leetcode.substr;

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

        // 新建自定义队列
        MyQueue pq = new MyQueue();
        int[] res = new int[nums.length - k + 1];

        // 先放入头 k 个使得队列头部为第一个最大值，这样可以无需每次在 for 内判断队列大小是否大于 k
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);
        // 将首元素加入 res
        int index = 0;
        res[index++] = pq.peek();

        // 遍历剩下元素，维护滑动窗口
        for (int j = k; j < nums.length; j++) {
            // 先尝试移除窗口左边界元素，右边再加入新元素，最后获取当前窗口最大值加入 res
            pq.poll(nums[j - k]);
            pq.offer(nums[j]);
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

    // 如果当前元素比队列尾部元素要大，则将队列尾部元素弹出，再加入元素
    public void offer(int num) {
        while (!deque.isEmpty() && num > deque.peekLast())
            deque.pollLast();
        deque.offer(num);
    }

    // 如果队头刚好是当前元素则 poll
    public void poll(int num) {
        if (!deque.isEmpty() && num == deque.peek())
            deque.poll();
    }

    // peek 直接返回队头最大元素
    public int peek() {
        return !deque.isEmpty() ? deque.peek() : -1;
    }
}
