package round2.hot100.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /*
        三数之和
         i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0
         双指针，两层循环，第一层控制 i 可去重以及剪枝，第二层控制左右指针
         - 当 a + b + c < 0，说明左指针元素小了，左指针右移
         - 当 a + b + c < 0，说明右指针元素大了，右指针左移
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 需要先保证数组内部元素有序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 剪枝
            if (nums[i] > 0)
                return res;

            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    --right;
                else if (sum < 0)
                    ++left;
                else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 只有添加了元素后才需要分别对左右指针去重
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;
                    // 还要再搜索一个位置才能正确指向下一个不重复的元素
                    ++left;
                    --right;
                }
            }
        }

        return res;
    }
}
