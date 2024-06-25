package round2.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    /*
        四数之和
        与三数之和类似，嵌套多一层循环再通过双指针遍历
        差别在于，多了 target，剪枝上需注意
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // a + b + c + d
        // num[i] = a, num[j] = b, num[left] = c, num[right] = k
        for (int i = 0; i < nums.length; i++) {
            // 先对 i 剪枝
            // 前提必须 target > 0，target 有可能为负数
            if (nums[i] > 0 && nums[i] > target)
                return res;
            // 对 i 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                // 也可以再剪枝
                // 对 j 去重
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // 定义左右指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target)
                        ++left;
                    else if (sum > target)
                        --right;
                    else {
                        // 将当前四元组加入到 res 中
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对左右指针去重
                        while (left < right && nums[left] == nums[left + 1])
                            ++left;
                        while (left < right && nums[right] == nums[right - 1])
                            --right;
                        // 移动到下一个四元组位置
                        ++left;
                        --right;
                    }
                }
            }
        }
        return res;
    }
}
