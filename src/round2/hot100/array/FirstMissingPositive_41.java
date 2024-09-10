package round2.hot100.array;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive_41 {
    /*
        两种思路：
        1. 遍历数组用 hashSet 存所有元素，
            再从 1 开始遍历，如果 set 中不存在则立刻返回，都存在则返回数组长度 + 1

        2. 按题目要求只能使用参数级别的额外空间
            遍历一次数组把大于等于1的和小于数组大小的值 swap 放到原数组对应位置，
            然后再遍历一次数组查当前下标是否和值对应，
            如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1)
            return nums[0] == 1 ? 2 : 1;

        for (int i = 0; i < nums.length; i++) {
            // [1, 2, 3] [2, 1, 3]  [1, 1]
            if (nums[i] != i + 1)
                // 因为可能交换过后的这个数字还是不位于 nums[i] - 1 的下标上，需要用 while
                // nums[i] != nums[nums[i] - 1]，如果 nums[i] 没有处于它应该处于 nums[i] - 1 下标的话
                while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
                    swap(nums, nums[i] - 1, i);
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return nums.length + 1;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int firstMissingPositive_1(int[] nums) {
        if (nums.length == 1)
            return nums[0] == 1 ? 2 : 1;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        for (int i = 1; i <= nums.length; i++)
            if (!set.contains(i))
                return i;

        return nums.length + 1;
    }
}
