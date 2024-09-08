package round2.hot100.substr;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class myQueue {
    Deque<Integer> deque;

    public myQueue() {
        this.deque = new LinkedList<>();
    }

    public void poll(int val) {
        if (!deque.isEmpty() && deque.peek() == val)
            deque.poll();
    }

    public int peek() {
        if (!deque.isEmpty())
            return deque.peek();
        return -1;
    }

    public void offer(int val) {
        // 维护单调性，保持队列头部为最大元素，将尾部小于当前元素的都 poll
        while (!deque.isEmpty() && val > deque.peekLast())
            deque.pollLast();

        deque.offer(val);
    }
}

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

        myQueue pq = new myQueue();
        // 定义数组储存每个窗口的最大值
        int[] res = new int[nums.length - k + 1];

        // 先将头 k 个元素加入到 pq 中
        for (int i = 0; i < k; i++)
            pq.offer(nums[i]);

        int index = 0;
        res[index++] = pq.peek();
        // 将剩余元素加入到 pq 中
        for (int i = k; i < nums.length; i++) {
            // 先移除队列窗口中的最左边元素，再加入右边元素
            pq.poll(nums[i - k]);
            pq.offer(nums[i]);
            // 再取头部获取当前窗口内的最大值
            res[index++] = pq.peek();
        }

        return res;
    }
}
