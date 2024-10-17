package round2.hot100.others;

public class SortColors_75 {
    // 颜色分类
    // 双指针遍历，分别用于交换 0 和 2
    public void sortColors(int[] nums) {
        int ptr0 = 0;
        int ptr2 = nums.length - 1;

        for (int i = 0; i <= ptr2; i++) {
            // 如果 nums[i] 等于 0，和 ptr0 交换
            if (nums[i] == 0) {
                nums[i] = nums[ptr0];
                nums[ptr0++] = 0;

            }
            // 如果 nums[i] 等于 2，和 ptr2 交换
            else if (nums[i] == 2) {
                nums[i] = nums[ptr2];
                nums[ptr2--] = 2;
                if (nums[i] != 1)
                    --i;
            }
        }
        return;
    }
}
