package round4.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea_84 {
    /*
        柱状图中最大的矩形
        本质就是以当前(中间柱子)高度向两边扩展，所以需要找第一个比它矮的柱子
        单调递减栈保证了找到左边比它小的柱子，现在找右边第一个比他矮的柱子
        为了正常 pop 出元素，在原数组上头尾加 0
        1. 大于栈顶元素直接 push
        2. 等于的话先 pop 再 push，避免重复计算
        3. 如果小于栈顶元素，pop 出来中间柱子左为高度，看栈是否为空，不为空则此时栈顶为左柱子下标，计算面积
    */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1)
            return heights[0];
        // 复制数组，头尾插 0
        int[] h = new int[heights.length + 2];
        h[0] = 0;
        for (int i = 0; i < heights.length; i++)
            h[i + 1] = heights[i];
        h[h.length - 1] = 0;

        // 新建单调递减栈，压入第一个元素
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int maxArea = 0;

        for (int i = 1; i < h.length; i++) {
            // 大于栈顶直接压入
            if (h[i] > h[stack.peek()])
                stack.push(i);
                // 等于先 pop 后 push 避免重复计算
            else if (h[i] == h[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }
            // 小于
            else {
                while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                    // pop 出中间的柱子作为高，h[i] 为右边的柱子
                    int midIndex = stack.pop();
                    int height = h[midIndex];
                    // 如果栈不为空，此时栈顶为左边的柱子
                    if (!stack.isEmpty()) {
                        int leftIndex = stack.peek();
                        int width = i - leftIndex - 1;
                        maxArea = Math.max(maxArea, height * width);
                    }
                }
                // 将当前元素压入栈中
                stack.push(i);
            }
        }

        return maxArea;
    }
}
