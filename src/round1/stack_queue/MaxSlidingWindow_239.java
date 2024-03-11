package round1.stack_queue;

import java.util.ArrayDeque;

public class MaxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 维护一个大小为 k 的自定义单调队列，出口处始终为当前最大元素
        // 当 push 进新的元素时，如果比出口处元素大，pop 直到前面为最大元素（当前元素）
        // 往前滑动窗口且队列元素个数到达 3 时，pop 队列出口元素

        // 使用双端队列手动实现单调队列，队列用来储存对应下标
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        // j 为 nums 下标，为窗口的末尾
        for (int j = 0; j < len; j++) {
            // 在 [j - k + 1, j] 的范围内找到当前窗口最大值
            // 往前滑动窗口，如果队列内的下标不在该范围内要 pop
            while (!deque.isEmpty() && deque.peek() < j - k + 1)
                deque.poll();
            // 保证为单调队列，保证每次但进去的数字要比末尾大
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j])
                deque.pollLast();
            // 把新元素的下标 push 进队列
            deque.offer(j);

            // 当 i 增长到符合第一个 k 范围时，每滑动一步都将队列头节点放入 res
            if (j - k + 1 >= 0)
                res[index++] = nums[deque.peek()];
        }
        return res;
    }

    public int[] maxSlidingWindow_2(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        for (int j = 0; j < len; j++) {
            // 检查当前元素下标是否还在当前窗口范围内
            while (!deque.isEmpty() && deque.peek() < j - k + 1)
                deque.poll();
            // 保证为单调队列，进入队列时将小于该元素的元素都拿走
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j])
                deque.pollLast();
            // 将元素队列下标加入到队列中
            deque.offer(j);

            // 开始滑动窗口并且再符合的范围内，每次滑动将队列头节点加入到 res 中
            if (j - k + 1 >= 0)
                res[index++] = nums[deque.peek()];
        }
        return res;
    }
}
