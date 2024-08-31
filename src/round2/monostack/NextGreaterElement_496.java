package round2.monostack;

import java.util.*;

public class NextGreaterElement_496 {
    /*
        下一个更大元素 I
        和每日温度基本相同，但变成了两个数组，
        需要找 nums1 中数字 x 的在 nums2 中对应位置右侧的第一个比 x 大的元素
        主要思路:
        1. 同样使用单调递增栈，存 nums2 的下标
        2. 同时 nums1 和 nums2 没有重复元素，所以用可以用 map 储存 nums1 元素和其下标
        3. 初始化 res 为 -1，遍历 nums2
        4. 如果当前元素 <= 栈顶元素，直接入栈
               当前元素 > 栈顶元素，则看栈顶元素是否在 nums1(map) 中存在
                存在就更新 res 中为当前元素
                循环将所有小于当前元素的栈顶元素都弹出后，加入当前元素
     */

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 初始化 res
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        // 将 nums1 的元素及其下标记录到 map 中
        // key: 元素  val: 下标
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++)
            map.put(nums1[i], i);

        // 维护单调递增栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        // 遍历 nums2 数组
        for (int i = 1; i < nums2.length; i++) {
            // 当前元素小于栈顶，直接入栈
            if (nums2[i] <= nums2[stack.peek()])
                stack.push(i);
            else {
                // 当前元素大于栈顶，需要弹出
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                    // 看栈顶元素是否存在与 nums1 的 map 中
                    if (map.containsKey(nums2[stack.peek()])) {
                        // 栈顶元素在 nums1 存在的话，
                        // 说明当前元素是 nums1 该元素在 nums2 中找到比其大的下一个元素
                        int preIndex = stack.peek();
                        res[map.get(nums2[preIndex])] = nums2[i];
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return res;
    }
}
