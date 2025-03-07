package round4.leetcode.doubleptr;

public class MoveZeroes_283 {
    /*
        移动零
        双指针，只要不是 0 的就往前移动，是 0 就交换
        一个指针指向下一个位置准备交换，一个指针搜索非 0 元素
    */
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1)
            return;

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left++] = temp;
            }
        }
    }
}
