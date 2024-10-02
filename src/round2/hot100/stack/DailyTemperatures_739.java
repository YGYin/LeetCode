package round2.hot100.stack;

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
            - 大于栈顶的，先全部 pop 出来再压入，同时记录当前元素为栈内元素遇到第一个比其大的下标
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 1)
            return new int[]{0};
        // 储存答案
        int[] res = new int[temperatures.length];
        // 新建栈
        Deque<Integer> stack = new LinkedList<>();
        // 压入第一个元素下标作为初始值
        stack.push(0);

        // 遍历数组
        for (int i = 1; i < temperatures.length; i++) {
            // 如果当前元素小于等于栈顶，直接 push
            if (temperatures[i] <= temperatures[stack.peek()])
                stack.push(i);
            else {
                // 将所有比当前元素小的都先 pop 出来
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    // 找到当前元素为第一个比之前元素大的元素
                    // 题目要求记录的为两者差值
                    int preIndex = stack.pop();
                    res[preIndex] = i - preIndex;
                }
                // 再 push 当前元素
                stack.push(i);
            }
        }
        return res;
    }
}
