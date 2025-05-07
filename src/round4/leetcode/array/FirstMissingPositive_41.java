package round4.leetcode.array;

public class FirstMissingPositive_41 {
    /*
        按题目要求只能使用常数级别的额外空间
        将数组本身当为哈希表使用，元素 1 放到下标 0，2 放到下标 1，nums[i] 放到 i - 1 的位置
        遍历一次数组把大于 0 的，不超过数组长度的，且不在正确位置的值 swap 放到原数组对应位置，
        然后再遍历一次数组查当前下标是否和值对应，
        如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加 1
     */
    public int firstMissingPositive(int[] nums) {
        int arrLen = nums.length;

        // 遍历数组，将所有正整数放到对应下标 nums[i] - 1 的位置
        // 使用 if 不能保证当前位置 i 上放置正确元素，反例 [3, 4, -1, 1]
        for (int i = 0; i < arrLen; i++)
            while (nums[i] > 0 && nums[i] <= arrLen && nums[nums[i] - 1] != nums[i])
                swap(nums, nums[i] - 1, i);

        // 再遍历一次，如果存在下标 i 的值不等于 i + 1 直接返回
        for (int i = 0; i < arrLen; i++)
            if (nums[i] != i + 1)
                return i + 1;

        return arrLen + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
