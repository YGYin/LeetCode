package round2.hot100.doubleptr;

public class moveZeros_283 {
    /*
        移动零
        不能改变原来的相对顺序，遇到非 0 的就交换放到前面
     */
    public void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;
        int curIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[curIndex];
                nums[curIndex++] = temp;
            }
        }
    }
}
