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
            - 比当前元素大，则一直 pop 累加雨水，直到栈没有比当前元素小的
     */
    public int trap(int[] height) {
        // 特判
        if (height.length == 1)
            return 0;
        // 新建栈，储存元素下标，直接映射回原来的数组，记得先 push 首元素
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int res = 0;

        // 遍历数组
        for (int i = 1; i < height.length; i++) {
            // 小于栈顶直接 push
            if (height[i] < height[stack.peek()])
                stack.push(i);
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // 先获取中间柱子下标
                    int midIndex = stack.pop();
                    int midHeight = height[midIndex];
                    if (!stack.isEmpty()) {
                        // 此时栈顶为 左边 柱子的高度，不需要 pop 出来
                        int leftHeight = height[stack.peek()];
                        int w = i - stack.peek() - 1;
                        int h = Math.min(leftHeight, height[i]) - midHeight;
                        res += w * h;
                    }
                }
                // 记得将当前元素 push 进去
                stack.push(i);
            }
        }

        return res;
    }
}
