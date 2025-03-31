package round4.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures_739 {
    /*
        每日温度
        找到第一个比当前温度高的
        主要思路：
        1. 找到第一个比当前数大的，使用单调递增栈，栈内直接存数组下标，可以直接映射回数值
        2. 主要比较当前元素和栈顶元素的关系
            - 遇到小于等于栈顶的，入栈
            - 大于栈顶的，先全部 pop 出来，说明栈顶遇到第一个比自己温度高的元素
                记录两者下标距离到 res 中，最后再压入当前元素
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1)
            return new int[]{0};

        // 定义单调递增栈存元素下标以及数组记录结果
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        // 需要先压入第一个下标
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            // 当前元素 <= 栈顶直接入栈
            if (temperatures[i] <= temperatures[stack.peek()])
                stack.push(i);
            else {
                // 如果当前元素 > 栈顶，将小于当前元素的全部 pop 出来，记录到 res
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int preIndex = stack.pop();
                    res[preIndex] = i - preIndex;
                }
                // 将当前元素入栈
                stack.push(i);
            }
        }
        return res;
    }
}
