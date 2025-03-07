package round4.leetcode.doubleptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /*
        三数之和
        需要先对原数组排序
        1. for 循环在外控制 a，剪枝和去重后，左右双指针分别指向两端找 b c
        2. 当相加 大于 0 缩小右指针，小于 0 扩大右指针，如果相等就加入 res 中并分别对左右指针去重
        3. 记得去重后需要再收缩一次左右指针才到下一个待判断的位置
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 剪枝，如果当前 nums[i] 已经大于 0 可直接返回
            if (nums[i] > 0)
                return res;
            // 去重，如果和前一个相等，不需要重复加入
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                    ++left;
                else if (sum > 0)
                    --right;
                else {
                    // 加入 res 中
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 再分别对左右指针去重
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;
                    // 再收缩一次左右指针到下一次待判断位置
                    ++left;
                    --right;
                }
            }
        }
        return res;
    }
}
