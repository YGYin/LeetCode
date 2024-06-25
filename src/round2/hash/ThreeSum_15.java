package round2.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    /*
        三数之和
        寻找三元组满足三个数互不相等，同时相加和为 0，
        且不能包含重复的三元组
        1. 先讲数组排序后，用双指针，a = nums[i], b = nums[left], c = buns[right]
        2. a + b + c < 0 说明不够大，左指针++
           a + b + c > 0 说明不够大，右指针--
        去重要注意使用当前元素 i 和 i - 1 元素比较，否则会跳过正确三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先对原数组排序
        Arrays.sort(nums);
        // a + b + c
        for (int i = 0; i < nums.length; i++) {
            // 可以先剪枝，当排序后第一个元素已经大于 0，没有可能三元组相加为 0
            if (nums[i] > 0)
                return res;
            // 然后对 i 去重，和前一个元素相比看是否相同
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
            // 左右相等无意义
            while (left < right) {
                // a + b + c
                int sum = nums[i] + nums[left] + nums[right];
                // 如果当前 sum < 0，说明太小，++left
                if (sum < 0)
                    ++left;
                else if (sum > 0)
                    --right;
                    // sum == 0
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 找到当前三元组后，对左右指针去重
                    while (left < right && nums[left] == nums[left + 1])
                        ++left;
                    while (left < right && nums[right] == nums[right - 1])
                        --right;
                    // 再搜索一下指针，刚好指向下一个待判断的三元组
                    ++left;
                    --right;
                }
            }
        }
        return res;
    }
}
