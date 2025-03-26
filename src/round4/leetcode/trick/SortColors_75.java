package round4.leetcode.trick;

import java.util.Arrays;

public class SortColors_75 {
    /*
        颜色分类
         双指针分别指向数组左右两端，然后从左到右遍历数组，
         用双指针分别用于交换 0 和 2，保证所有 0 在左边，所有 2 在右边
         注意等于 2 的时候，和右边指针交换，但和尾部交换后，i 不能加 1，因为交换过来尾部元素没有遍历过
    */
    public void sortColors(int[] nums) {
        if (nums.length <= 1)
            return;
        // 定义双指针
        int ptr0 = 0, ptr2 = nums.length - 1;

        // 从左到右遍历数组
        int i = 0;
        while (i <= ptr2 && i < nums.length) {
            // 等于 0，和左边指针交换
            if (nums[i] == 0) {
                nums[i] = nums[ptr0];
                nums[ptr0++] = 0;
                i++;
            }
            // 等于 2，和右边指针交换，但是和尾部交换后，i 不能加 1，因为交换过来尾部元素没有遍历过
            else if (nums[i] == 2) {
                nums[i] = nums[ptr2];
                nums[ptr2--] = 2;
            } else
                i++;
        }
    }

    public static void main(String[] args) {
        SortColors_75 color = new SortColors_75();
        color.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
