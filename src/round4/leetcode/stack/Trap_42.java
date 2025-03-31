package round4.leetcode.stack;

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
        if (height.length == 1)
            return 0;
        // 单调递增栈，加入第一个元素
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            // 小于栈顶直接加入
            if (height[i] < height[stack.peek()])
                stack.push(i);
                // 等于栈顶，先 pop 再 push 避免重复计算
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }
            // 大于栈顶，计算高度
            else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int midIndex = stack.pop();
                    int midHeight = height[midIndex];
                    // 如果不为空，此时栈顶为左侧柱子
                    if (!stack.isEmpty()) {
                        int leftIndex = stack.peek();
                        // 高度取左右柱子较矮者与中间柱子的高度差
                        int h = Math.min(height[leftIndex], height[i]) - midHeight;
                        int w = i - leftIndex - 1;
                        res += (h * w);
                    }
                }
                // 加入当前元素到栈
                stack.push(i);
            }
        }
        return res;
    }
}
