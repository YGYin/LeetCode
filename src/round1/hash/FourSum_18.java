package round1.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4)
            return res;

        // 先对数组排序
        Arrays.sort(nums);

        for (int a = 0; a < nums.length; a++) {
            // 剪枝，（排除 a 和 target 都是负数的情况下）
            // 当 a 比 target 大时直接返回
            if (nums[a] > 0 && nums[a] > target)
                return res;
            // 对 a 去重
            if (a > 0 && nums[a] == nums[a - 1])
                continue;

            for (int b = a + 1; b < nums.length; b++) {
                // 对 b 去重
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;

                // 定义左右指针
                int left = b + 1;
                int right = nums.length - 1;
                // 双指针遍历
                while (left < right) {
                    // 用 int 有可能溢出
                    long sum = (long) nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum < target)
                        left++;
                    else if (sum > target)
                        right--;
                    else {
                        // 先收获第一个正确的四元组，再分别对 c 和 d 去重
                        res.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        // 去重
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        // 收缩指针到当前正确的 c d 位置
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
