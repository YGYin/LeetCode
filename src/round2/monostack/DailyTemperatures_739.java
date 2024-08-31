package round2.monostack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures_739 {
    /*
        每日温度
        单调栈使用场景:
            通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，
            此时要想到可以用单调栈，用来存放记录遍历过的元素，和当前遍历元素做对比
            栈顶元素实际为之前遍历过但还未找到第一个比其大或者小的元素
        - 如果栈顶到栈底为递增的话，求的为遇到第一个比当前元素大的元素
        - 如果为递减，则求的为当前元素遇到第一个比其小的元素

        主要思想：
        1. 因为求的为第一个比当前元素大的元素，使用单调递增的单调栈，
            可以直接存元素的下标，直接用数组映射到对应元素
        2. 当当前元素 <= 栈顶元素时，直接入栈继续保持栈单调递增
        3. 如果当前元素 > 栈顶元素，说明栈顶元素找到第一个比其大元素，
            弹出栈并记录距离到 res 数组中，将栈里所有小于当前元素都弹出并记录，
            维护单调递增，最后再将当前元素压入栈中
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        if (temperatures.length == 1)
            return res;

        // 新建单调递增栈，实际存的为元素下标
        Deque<Integer> stack = new LinkedList<>();
        // 栈实现建议使用 deque 中的 push pop 和 peek
        stack.push(0);

        // 遍历温度数组
        for (int i = 1; i < temperatures.length; i++) {
            // 如果当前元素小于栈顶元素直接入栈
            if (temperatures[i] <= temperatures[stack.peek()])
                stack.push(i);
            else {
                // 将所有比当前元素小元素都弹出，并记录之前元素遇到第一个比其大的元素的距离
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int pre = stack.pop();
                    res[pre] = i - pre;
                }
                // 再压入当前元素到栈中，保证单调递增
                stack.push(i);
            }
        }
        return res;
    }
}
