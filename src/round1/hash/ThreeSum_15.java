package round1.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 求不重复的三元组，三元组要去重
        // 先将数组排序
        Arrays.sort(nums);
        // 用双指针，左端在 i 后一位，右指向数组末尾
        for (int i = 0; i < nums.length; i++) {
            // 剪枝，如果排序后第一位已经大于 0 无需查找后续元素
            if (nums[i] > 0)
                return res;
            // 先对 nums[i] 去重
            // 此处不能比较 nums[i] 和 nums[i + 1]，会导致跳过 nums[left]
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 定义左右指针
            int left = i + 1;
            int right = nums.length - 1;
            // 开始双指针遍历
            // 如果 i + left + right 小于 0 -> 左指针右移
            // 反之右指针左移
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 在收获第一个正确三元组结果后，
                    // 再对 nums[left] 和 nums[right] 去重
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;
                    // 上述去重后，分别都指向不重复的元素的前一位
                    // 需收缩指针到正确位置
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
