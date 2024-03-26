package round1.hot100.doubleptr;

public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int slowP = 0;
        int fastP = 0;
        while (fastP < nums.length) {
            // 慢指针指向非零部份的尾部，快指针交换每个非零元素到慢指针位置
            // 只有交换完非零元素后才移动慢指针
            if (nums[fastP] != 0)
                swap(nums, slowP++, fastP);
            ++fastP;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
