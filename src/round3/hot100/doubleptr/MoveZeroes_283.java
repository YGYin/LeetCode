package round3.hot100.doubleptr;

public class MoveZeroes_283 {
    /*
        移动零
        双指针，只要不是 0 的就往前移动
        一个指针指向下一个位置准备交换，一个指针搜索非 0 元素
    */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;

        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 和当前指针位置的元素交换，更新指针
                int temp = nums[ptr];
                nums[ptr++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
