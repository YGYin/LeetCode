package round1.hot100.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (nums[i] > 0)
                return res;
            // 对 i 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 小了，左边加
                if (sum < 0)
                    ++left;
                else if (sum > 0)
                    --right;
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    // 对 left 和 right 去重
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;
                    // 收缩指针到正确位置
                    ++left;
                    --right;
                }
            }
        }
        return res;
    }
}
