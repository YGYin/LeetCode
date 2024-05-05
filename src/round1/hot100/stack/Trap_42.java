package round1.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Trap_42 {
    public int trap(int[] height) {
        // 接雨水，单调栈
        // 因为要找到右边比自己大的，才能确认当前位置凹槽
        // 所以用单调递增栈(栈顶为最小元素)，存放的为元素下标
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 当栈不为空且当前元素大于栈顶元素时，
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // pop 出当前元素，计算对应高和宽，此时其为中间的凹槽底部
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    // 当前柱子为凹槽右边柱子，
                    // 栈顶为左边柱子，两者做比较，较小一方于凹槽底部的差为高度
                    int h = Math.min(height[i], height[stack.peek()]) - height[mid];
                    // 宽为当前柱子下标与栈顶下标的差 - 1
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            // 当当前元素等于或者小于栈顶元素时
            stack.push(i);
        }
        return sum;
    }
}
