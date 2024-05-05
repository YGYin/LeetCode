package round1.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures_739 {

    public int[] dailyTemperatures(int[] temperatures) {
        // 每日温度：输出数组，当前还需要过多少天才会升高温度
        // 1. 暴力，从左到右每个树都遍历一次，遍历的时候每个数都向后数，直到找到比他大的值

        // 2. 要找到右边比自己大的 -> 维护递增栈（栈顶最小）
        //  遍历整个数组，如果当前元素比栈顶元素小，将其 数组下标 直接入栈，
        //  如果大于栈顶的元素，只要栈不为空，就将其 pop 出来，并计算两者的下标差存入 res 里
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            // 如果大于栈顶的元素，只要栈不为空，就将其 pop 出来，并计算两者的下标差存入之前下标的 res 里
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            // 如果当前元素比栈顶元素小，将其 数组下标 直接入栈
            stack.push(i);
        }

        return res;
    }
}
