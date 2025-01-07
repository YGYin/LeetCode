package round3.hot100.stack;

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
        // 新建数组储存答案
        int[] res = new int[temperatures.length];
        // 新建单调递增栈，储存的为下标，可以直接通过数组映射回元素
        Deque<Integer> stack = new LinkedList<>();
        // 先压入第一个元素下标
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            // 如果小于或等于栈顶元素，直接入栈
            if (temperatures[i] <= temperatures[stack.peek()])
                stack.push(i);
            else {
                // 栈内所有小于当前元素的都 pop 出来，并记录其与当前元素下标的距离
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
