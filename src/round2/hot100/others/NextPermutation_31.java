package round2.hot100.others;

public class NextPermutation_31 {
    /*
        31. 下一个排列
        需要算法可以找到一个大于当前序列的行序列，且变大的幅度尽可能的小
        - 将一个左边的「较小数」与一个右边的「较大数」交换，
           以能够让当前排列变大，从而得到下一个排列
        - 让这个「较小数」尽量靠右，而「较大数」尽可能小
           「较大数」右边的数需要按照升序重新排列。
           这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小
        步骤:
        1. 从后往前查找第一个顺序对(i, i+1)，满足 a[i] < a[i+1]
            此时 a[i] 为较小数，[i+1, n) 必然为下降序列
            如果找不到顺序对，说明此时序列为降序序列（最大序列），直接步骤 3 反转
        2. 找到顺序对后，在 [i+1, n) 中从后往前找到第一个元素 j 满足 a[i] < a[j]
            a[j] 则为尽可能小的较大数
        3. 交换 a[i] 和 a[j]，因为 [i+1, n) 必为降序，
            需要变为升序才能使变大的幅度尽可能小，反转这个范围的数组
     */
    public void nextPermutation(int[] nums) {
        // 从后往前查找第一个顺序对(i, i+1)，满足 a[i] < a[i+1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            --i;

        // 找到顺序对后，在 [i+1, n) 中从后往前找到第一个元素 j 满足 a[i] < a[j]
        // 因为要找一个尽可能小的较大数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i + 1 && nums[i] >= nums[j])
                --j;

            // 在 [i+1, n) 中要找一个尽可能小的较大数后，交换 a[i] a[j]
            swap(nums, i, j);
        }
        // 因为 [i+1, n) 必为降序，需要变为升序才能使变大的幅度尽可能小，反转这个范围的数组
        reverseArray(nums, i + 1, nums.length - 1);
    }

    private void reverseArray(int[] nums, int left, int right) {
        while (left < right)
            swap(nums, left++, right--);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
