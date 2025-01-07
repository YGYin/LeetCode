package round3.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Trap_42 {
    /*
        接雨水
        1. 单调栈，找右边第一个比栈顶元素大的，单调递增栈
        2. 分三类讨论，
            - 比栈顶元素小直接入栈
            - 和栈顶元素相同的话先 pop 再 push 当前元素
            - 比当前元素大，则一直 pop 出来中间柱子，此时如果栈不为空，栈顶为左柱子，
                取左右柱子较矮者与中间柱子差值为高度，累加雨水，直到栈没有比当前元素小的
     */
    public int trap(int[] height) {
        if (height.length <= 1)
            return 0;
        int res = 0;
        // 新建单调递增栈，并压入首元素
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < height.length; i++) {
            // 如果小于栈顶元素，直接入栈
            if (height[i] < height[stack.peek()])
                stack.push(i);
                // 如果相同则先 pop 后 push，保证后续计算用的是高度相同靠右的柱子
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }
            // 大于栈顶元素
            else {
                // 重复尝试 pop 出中间柱子，维护单调性
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int midIndex = stack.pop();
                    int midHeight = height[midIndex];
                    // 如果栈 pop 完中间柱子任不为空，计算水的体积
                    if (!stack.isEmpty()) {
                        // 高度为左右两者较矮者与中间高度的差
                        int h = Math.min(height[stack.peek()], height[i]) - midHeight;
                        int w = i - stack.peek() - 1;
                        res += h * w;
                    }
                }
                // 将当前元素 push 入栈
                stack.push(i);
            }
        }
        return res;
    }
}
