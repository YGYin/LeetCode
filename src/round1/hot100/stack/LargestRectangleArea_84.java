package round1.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleArea_84 {
    public int largestRectangleArea(int[] heights) {
        // 柱状图中最大的矩形，与接雨水相似
        // 接雨水找左右第一个比栈顶元素大的，此题找左右第一个比栈顶小的
        // 前求外部凹槽面积，后求内部覆盖面积
        // 单调递减栈

        // 数组扩容，需要在头尾加 0 方便操作
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[0] = 0;
        newHeight[heights.length + 1] = 0;

        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 存数组下标
        for (int i = 0; i < newHeight.length; i++) {
            // 当前元素小于栈顶元素时
            while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                // 取出来中间柱子
                int mid = stack.pop();
                // 直接求内部面积 = 中间柱子的高 * (左右柱子下标差 - 1)
                int h = newHeight[mid];
                int w = i - stack.peek() - 1;
                // 因为求最大面积，此处更新变量
                res = Math.max(res, h * w);
            }
            // 当前元素大于等于栈顶元素时
            stack.push(i);
        }

        return res;
    }

    private int bruteForce(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;

        int res = 0;
        // 依次遍历每个柱形的高度
        for (int i = 0; i < len; i++) {
            // 分别向两边扩散，看满足当前高度的矩形的最大宽度是多少
            int curHeight = heights[i];
            // 向左
            int left = i;
            while (left > 0 && heights[left - 1] >= curHeight)
                --left;
            // 向右
            int right = i;
            while (right < left - 1 && heights[right + 1] >= curHeight)
                ++right;

            int width = right - left + 1;
            res = Math.max(res, curHeight * width);
        }
        return res;
    }
}
