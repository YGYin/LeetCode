package round1.hot100.substr;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_239 {
    // 自定义单调队列
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        // 弹出元素时，需要队列非空，且比较当前要弹出的数值是否等于队列出口的数值
        void pop(int val) {
            if (!deque.isEmpty() && val == deque.peek())
                deque.poll();
        }

        // 往队列添加元素时，如果添加元素大于队列入口处元素，就讲入口处元素弹出
        // 以保证队列元素单调递减
        void push(int val) {
            while (!deque.isEmpty() && val > deque.peekLast())
                deque.removeLast();
            deque.add(val);
        }

        // 队列顶部元素始终为当前队列的最大值
        int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1)
            return nums;
        int[] res = new int[nums.length - k + 1];

        MyQueue queue = new MyQueue();
        // 先将前 k 个元素放入队列中
        for (int i = 0; i < k; i++)
            queue.push(nums[i]);

        // 将当前最大值放入到 res 中
        int index = 0;
        res[index++] = queue.peek();
        // 遍历剩余 nums 数组
        for (int i = k; i < nums.length; i++) {
            // 每新加一个元素就得先移除头部元素
            queue.pop(nums[i - k]);
            // 加入新元素
            queue.push(nums[i]);
            // 获取队列首元素，及当前最大值加入到 res 中
            res[index++] = queue.peek();
        }
        return res;
    }
}
