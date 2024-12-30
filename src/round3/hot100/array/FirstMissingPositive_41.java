package round3.hot100.array;

public class FirstMissingPositive_41 {
    /*
        按题目要求只能使用常数级别的额外空间
        将数组本身当为哈希表使用，元素 1 放到下标 0，2 放到下标 1
        遍历一次数组把大于 0 的，不超过数组长度的，且不在正确位置的值 swap 放到原数组对应位置，
        然后再遍历一次数组查当前下标是否和值对应，
        如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加 1
     */
    public int firstMissingPositive(int[] nums) {
        int arrLen = nums.length;
        // 特判
        if (arrLen == 1)
            return nums[0] == 1 ? 2 : 1;

        // 遍历一次数组，交换元素到下标为 本身的值 - 1 的正确位置
        for (int i = 0; i < arrLen; i++)
            // 一次可能不成功，需要使用 while
            // 满足该值大于 0 且可以放置于数组长度内，并且数组中（值 - 1）正确位置没用放置当前元素
            while (nums[i] > 0 && nums[i] <= arrLen && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);

        // 在遍历一次数组，看是否存在不满足 nums[i] = i + 1 的情况
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i + 1;

        // 都满足，需要返回 arrLen + 1
        return arrLen + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
