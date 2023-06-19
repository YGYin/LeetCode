package coding.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_08 {
    /*
        思路：
            基本和三数之和逻辑相同，需要注意剪枝操作和去重操作的细节
            注意剪枝因为 a b 和 target 有可能都为负数，出现越加越小的情况
            所以 a > target && target > 0

        时间复杂度: O(n^3)
        空间复杂度: O(1)

     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 第一层剪枝
            if (nums[i] > target && target > 0)
                return res;
            // 第一层去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                // 第二层剪枝 ?
                if (nums[i] + nums[j] > target && target > 0)
                    break;
                // 第二层去重
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // int 可能会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target)
                        ++left;
                    else if (sum > target)
                        --right;
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对 c d 去重
                        while (left < right && nums[left] == nums[left + 1])
                            ++left;
                        while (left < right && nums[right] == nums[right - 1])
                            --right;
                        // 收缩双指针
                        ++left;
                        --right;
                    }
                }
            }
        }
        return res;
    }
}
