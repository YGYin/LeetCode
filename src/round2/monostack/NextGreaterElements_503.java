package round2.monostack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class NextGreaterElements_503 {
    /*
        下一个更大元素 II
        和每日温度相同，只是变成了一个环形数组，有两种思路可以用于模拟环形数组
        1. 直接复制当前数组并拼接在一起，resize 本身复杂度为 O(1) 但是复制元素为 O(n)
        2. 让 i 在遍历的时候 i < nums.length * 2，在遍历过程中取 i % nums.length，模拟环形数组

     */
    public int[] nextGreaterElements(int[] nums) {
        // 初始化 res 数组
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        // 初始化单调递增栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        // 遍历 nums
        for (int i = 1; i < nums.length * 2; i++) {
            // 如果 nums[i] <= 栈顶，直接入栈
            if (nums[i % nums.length] <= nums[stack.peek()])
                stack.push(i % nums.length);
            else {
                // 将所有小于栈顶元素的都 pop 出来
                while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                    int preIndex = stack.pop();
                    res[preIndex] = nums[i % nums.length];
                }
                // 再将当前元素入栈
                stack.push(i % nums.length);
            }
        }

        return res;
    }
}
