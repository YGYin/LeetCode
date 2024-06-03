package round1.hot100.trick;

public class SortColors_75 {
    /*
        一次遍历，同时用双指针来分别交换 0 和 2
     */
    public void sortColors(int[] nums) {
        int ptr0 = 0;
        int ptr2 = nums.length - 1;
        // 遍历 nums
        for (int i = 0; i <= ptr2; i++) {
            // 如果 nums[i] 为 0，和 ptr0 交换，然后 ptr0++
            // 因为换到前面来的是 0，不用额外处理
            if (nums[i] == 0) {
                nums[i] = nums[ptr0];
                nums[ptr0++] = 0;
            }
            // 如果 nums[i] 为 2，和 ptr2 交换，然后 ptr2--
            if (nums[i] == 2) {
                nums[i] = nums[ptr2];
                nums[ptr2--] = 2;
                // 但不知道交换回来的是不是 1，
                // 如果不是 1 需要回退到当前位置在下一次循环判断
                if (nums[i] != 1)
                    --i;
            }
        }
        return;
    }
}
