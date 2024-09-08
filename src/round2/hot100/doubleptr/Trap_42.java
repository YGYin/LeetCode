package round2.hot100.doubleptr;

import java.util.Deque;
import java.util.LinkedList;

public class Trap_42 {
    /*
     * 单调递增栈
     * 找到右边第一个比当前大的元素时，那么栈顶元素即为凹槽，栈顶元素前一个元素为左柱子
     * 接雨水面积按行计算，h = min(左柱，右柱) - 凹槽高度
     * - 当前元素 < 栈顶，直接入栈
     * - 当前元素 = 栈顶，因为要使用最靠外面的左柱子进行计算，先 pop 再 push
     * - 当前元素 > 栈顶，取出当前元素，计算面积，并一直 pop 进行计算维护单调性
     */
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 1)
            return res;

        // 初始化栈
        Deque<Integer> stack = new LinkedList<>();
        // 推入第一个元素下标
        stack.push(0);

        // 遍历数组
        for (int i = 1; i < height.length; i++) {
            // 讨论 当前元素 和 栈顶元素 的大小关系
            if (height[i] < height[stack.peek()])
                stack.push(i);
            else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                // 维护单调性，将所有小于当前元素的栈内元素都 pop 出来，并计算面积
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // 此时栈顶为中间凹槽
                    int mid = stack.pop();
                    // 栈有可能为空
                    if (!stack.isEmpty()) {
                        // 计算面积，此时栈顶为左柱
                        int w = i - stack.peek() - 1;
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        res += w * h;
                    }
                }
                // 记得最后将当前元素入栈
                stack.push(i);
            }
        }

        return res;
    }
}
