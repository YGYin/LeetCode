package coding.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_07 {
    /*
        思路:
            因为不用返回下标，可以先将数组排序
            a = nums[i], b = nums[left], c = nums[right]
            for 遍历数组为指针为 a，分别再用左右指针指向 i + 1 和 nums.length - 1
            left < right 时
            当加起来大于 0 left 右移，小于 0 right 左移
        去重:
            对 a 去重注意不能为 nums[i] == nums[i + 1]，会错过有重复数字组成的三元组
            找到三元组答案时，双指针同时收缩，再对 b c 进行去重

        时间复杂度: O(n^2)
        空间复杂度: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        // a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (nums[i] > 0)
                return res;
            // 对 a 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            // 固定 A 后找 B C
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    --right;
                else if (sum < 0)
                    ++left;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 对当前 b c 去重
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;
                    // 再收缩左右指针
                    ++left;
                    --right;
                }
            }
        }

        return res;
    }
}
