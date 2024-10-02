package round2.hot100.stack;

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
        // 原数组头尾都需要加 0，保证能够正确弹出元素
        int[] nums = new int[heights.length + 2];
        nums[0] = 0;
        for (int i = 0; i < heights.length; i++)
            nums[i + 1] = heights[i];
        nums[nums.length - 1] = 0;

        // 单调递减栈，压入首个元素
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < nums.length; i++) {
            // 单调递减栈
            // 遇到大于栈顶的直接 push
            if (nums[i] > nums[stack.peek()])
                stack.push(i);
            else if (nums[i] == nums[stack.peek()]) {
                // 因为不需要记录所有柱子的下标
                // 相同高度的柱子可以先 pop 出来 再 push 避免重复计算
                stack.pop();
                stack.push(i);
            } else {
                // 遇到比栈顶元素小的
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    // 当前元素为右边柱子，栈顶为中间，栈顶下一个元素为左边柱子
                    int mid = stack.pop();
                    // 以中间柱子作为高
                    int height = nums[mid];
                    // pop 完栈有可能为空
                    if (!stack.isEmpty()) {
                        // 计算宽度，更新最大面积
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
