package round2.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Trap_42 {
    /*
        接雨水
        单调递增栈，找到右边第一个比今天大的
        高度取左右矮的那根
     */
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        int res = 0;
        for (int i = 1; i < height.length; i++) {
            // 小于栈顶元素直接加入
            if (height[i] < height[stack.peek()])
                stack.push(i);
                // 因为要使用最靠外的柱子，需要将和栈顶相同的先 pop 再 push
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                // 大于栈顶则一直 pop 并累加接到的雨水
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    int midHeight = height[mid];
                    if (!stack.isEmpty()) {
                        int leftHeight = height[stack.peek()];
                        int h = Math.min(leftHeight, height[i]) - midHeight;
                        int w = i - stack.peek() - 1;
                        res += h * w;
                    }
                }
                // push 当前元素
                stack.push(i);
            }
        }
        return res;
    }
}
