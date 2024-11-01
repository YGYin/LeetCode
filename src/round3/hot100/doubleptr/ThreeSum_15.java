package round3.hot100.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /*
        三数之和
        需要先对原数组排序
        1. for 循环在外控制 a，左右双指针分别指向两端找 b c
        2. 当相加 大于 0 缩小右指针，小于 0 扩大右指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 减枝，如果当前已经 大于 0 的话直接跳过
            if (nums[i] > 0)
                return res;

            // 去重，如果 i > 0 并且和之前重复需要去重
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
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 分别对左右指针去重
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;

                    // 再收缩左右指针到下一个待判断的位置
                    ++left;
                    --right;
                }
            }
        }
        return res;
    }
}
