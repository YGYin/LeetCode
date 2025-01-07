package round3.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea_84 {
    /*
        柱状图中最大的矩形
        本质就是以当前(中间柱子)高度向两边扩展，所以需要找第一个比它矮的柱子
        单调递减栈保证了找到左边比它小的柱子，现在找右边第一个比他矮的柱子
    */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1)
            return heights[0];
        // 要保证数组元素能够正确弹出，原数组头尾都需要加 0
        int[] h = new int[heights.length + 2];
        h[0] = 0;
        for (int i = 0; i < heights.length; i++)
            h[i + 1] = heights[i];
        h[h.length - 1] = 0;

        // 找右边比自己矮的柱子，单调递减栈，push 首元素下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int maxArea = 0;

        for (int i = 1; i < h.length; i++) {
            // 大于栈顶元素直接 push
            if (h[i] > h[stack.peek()])
                stack.push(i);
                // 等于的话先 pop 再 push，避免重复计算
            else if (h[i] == h[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }
            // 如果小于栈顶元素
            else {
                while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                    // pop 出来中间柱子左为高度
                    int midIndex = stack.pop();
                    int height = h[midIndex];
                    // 看栈是否为空，不为空则此时栈顶为左柱子下标
                    if (!stack.isEmpty()) {
                        int width = i - stack.peek() - 1;
                        maxArea = Math.max(maxArea, height * width);
                    }
                }
                // 压入当前元素
                stack.push(i);
            }
        }

        return maxArea;
    }
}
