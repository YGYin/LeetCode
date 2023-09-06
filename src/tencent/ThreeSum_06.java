package tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_06 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先将数组排序
        Arrays.sort(nums);
        // for 再加双指针
        for (int i = 0; i < nums.length; i++) {
            // 如果 a 已经大于 0，后面数一定都大于 0，不成立
            if (nums[i] > 0)
                return res;
            // 对 a 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int b = i + 1;
            int c = nums.length - 1;
            // 固定 a 后双指针找 b c
            while (b < c) {
                int sum = nums[i] + nums[b] + nums[c];
                if (sum < 0)
                    ++b;
                else if (sum > 0)
                    --c;
                else {
                    res.add(Arrays.asList(nums[i], nums[b], nums[c]));
                    // 记得对 b c 去重
                    while (b < c && nums[b] == nums[b + 1])
                        ++b;
                    while (b < c && nums[c] == nums[c - 1])
                        --c;
                    ++b;
                    --c;
                }
            }
        }
        return res;
    }
}
