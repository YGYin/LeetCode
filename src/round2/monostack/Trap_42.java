package round2.monostack;

import java.util.Deque;
import java.util.LinkedList;

public class Trap_42 {
    /*
        接雨水
        单调递增栈，栈里存放下标，通过数组映射高度，使用栈的时候按照行方向来计算雨水，
        一旦发现当前元素高于当前栈顶的元素，说明出现了凹槽，
        栈顶元素的前一个元素就是凹槽左边的柱子，添加的当前元素为凹槽右边的柱子
        1. 当前元素 < 栈顶元素，直接入栈
        2. 当前元素 = 栈顶元素，当两根柱子高度相同时，因为要使用最靠外的柱子进行计算，先 pop 再 push 当前元素
        3. 当前元素 > 栈顶元素，说明栈顶元素为凹槽，pop 取出栈顶为 mid
            此时栈顶为凹槽左边的柱子，那么装雨水的高度则为 min(左柱子高度, 右柱子高度) - 凹槽高度
            宽度则为 右柱子下标 - 左柱子下标 - 1
            雨水体积为 高 * 宽
     */
    public int trap(int[] height) {
        int res = 0;
        // 初始化栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        // 遍历 height 数组
        for (int i = 1; i < height.length; i++) {
            // 当前元素 < 栈顶元素，直接入栈
            if (height[i] < height[stack.peek()])
                stack.push(i);
                // 两根柱子高度相同，因为要使用最靠外的柱子进行计算，先 pop 再 push 当前元素
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                // 说明栈顶元素为凹槽，pop 取出栈顶为 mid，注意要 while 遵循单调栈规则
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int midIndex = stack.pop();
                    // 此时栈顶为左柱子 (有可能为空，需要先判空)
                    if (!stack.isEmpty()) {
                        // 装雨水的高度则为 min(左柱子高度, 右柱子高度) - 凹槽高度
                        int h = Math.min(height[stack.peek()], height[i]) - height[midIndex];
                        int w = i - stack.peek() - 1;
                        res += h * w;
                    }
                }
                // 最后将当前元素 push 进单调栈
                stack.push(i);
            }
        }

        return res;
    }
}
