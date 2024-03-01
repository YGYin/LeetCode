package round1.array;

public class RemoveElement_27 {
    // 暴力
    // O(n^2)   O(1)
    public int removeElement_01(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++)
                    nums[j] = nums[j + 1];
                --size;
                // 因为下标 i 后面的元素都向前移动了一位
                // 为了确保下一次循环 i 位于当前正确下标所以 --
                --i;
            }
        }
        return size;
    }

    // 快慢双指针
    // 快指针遍历寻找新数组的元素
    // 慢指针指向更新 新数组下标的位置
    public int removeElement_02(int[] nums, int val) {
        int slowP = 0;
        for (int fastP = 0; fastP < nums.length; fastP++)
            // 只要不相等就用快指针的元素覆盖慢指针的元素
            // 等于要被删除的元素时，慢指针刚好指向该元素
            // 快指针移到下一个不需删除的元素，然后覆盖慢指针的元素
            if (nums[fastP] != val)
                nums[slowP++] = nums[fastP];

        return slowP;
    }

    // 相向双指针
    // 可以确保移动最少元素，分别找左边等于 val 和找右边不等于 val 的进行交换
    // 时间：O(n)
    public int removeElement_03(int[] nums, int val) {
        // 分别指向左右两端
        int left = 0;
        int right = nums.length - 1;
        // 左右区间相等有意义
        while (left <= right) {
            // 找左边等于 val 的元素
            while (left <= right && nums[left] != val)
                ++left;
            // 找右边不等于 val 的元素
            while (left <= right && nums[right] == val)
                --right;
            // 交换前确保 left < right 且不相等，相等交换无意义
            // 交换完移动下标
            if (left < right)
                nums[left++] = nums[right--];
        }
        // 最后返回左下标，左下标正好指向更新后数组的下一位
        // 因为数组开始下标为 0，所以刚好为新数组的元素个数
        return left;
    }
}
