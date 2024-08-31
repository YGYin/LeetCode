package round2.monostack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea_84 {
    /*
        柱状图中最大的矩形
          和接雨水正好相反，但思路相同
          因为需要找比当前柱子小的柱子来构成矩形，使用单调递减栈
          但要注意，需要在原数组的情况下头尾加 0，
          使得在 2468 或 8642 这种情况下能正确到第三种情况收获结果
        1. 当前元素 > 栈顶元素，直接入栈
        2. 当前元素 = 栈顶元素，高度相同时默认取最右边的柱子作为计算标准
        3. 当前元素 < 栈顶元素，说明找到右边第一个比它矮的柱子，
            当前栈顶 pop 出来后的下一个元素就是左边比它矮的柱子
            柱子面积就为 高 * 宽
            高 = heights[mid]
            宽 = 右柱下标 - 左柱下标 - 1
            最后 res 更新当前的最大面积
     */
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1)
            return heights[0];
        // 记得数组需要扩容，头尾插 0
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = newHeights[newHeights.length - 1] = 0;

        int heightIndex = 1;
        for (int i = 0; i < heights.length; i++)
            newHeights[heightIndex++] = heights[i];

        int res = 0;
        // 初始化单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < newHeights.length; i++) {
            // 当前元素 > 栈顶元素，直接入栈
            if (newHeights[i] > newHeights[stack.peek()])
                stack.push(i);
            else if (newHeights[i] == newHeights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                    // 先取出中间的下标
                    int midIndex = stack.pop();
                    // 此时栈顶元素变为左边比中间矮的柱子(有可能为空)
                    if (!stack.isEmpty()) {
                        // 计算宽和高，更新全局的最大矩形面积
                        int w = i - stack.peek() - 1;
                        int h = newHeights[midIndex];
                        res = Math.max(res, w * h);
                    }
                }
                // 将当前元素压入栈
                stack.push(i);
            }
        }
        return res;
    }
}
