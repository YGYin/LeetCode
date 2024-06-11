package job.top101.binary;

public class BM20_InversePairs {
    public int modNum = 1000000007;

    public int InversePairs(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        return mergeSort(0, len - 1, nums, temp);
    }

    private int mergeSort(int left, int right, int[] nums, int[] temp) {

        // 当左右边界相等时说明只剩下一个元素或者没有元素，停止划分
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        // 递归地对左半部分和右半部分分别进行排序，并加上各自的逆序对数量
        int res = mergeSort(left, mid, nums, temp) + mergeSort(mid + 1, right, nums, temp);

        res %= modNum;
        // 将当前区间复制到 temp 中
        for (int i = left; i <= right; i++)
            temp[i] = nums[i];
        // 定义比较左右 区间 1 和 区间 2 的指针
        int ptr1 = left;
        int ptr2 = mid + 1;
        // 对当前区间进行归并操作
        for (int i = left; i <= right; i++) {
            // 如果左半部分已经完全归并，直接归并右半部分
            if (ptr1 == mid + 1)
                nums[i] = temp[ptr2++];
                // 如果右半部分已经完全归并，或者左半部分当前值小于等于右半部分当前值，归并左半部分
            else if (ptr2 == right + 1 || temp[ptr1] <= temp[ptr2])
                nums[i] = temp[ptr1++];
                // 否则，存在逆序对，归并右半部分，并统计逆序对数量
            else {
                nums[i] = temp[ptr2++];
                // 统计逆序对
                res += mid - ptr1 + 1;
            }
        }
        return res % modNum;
    }
}
