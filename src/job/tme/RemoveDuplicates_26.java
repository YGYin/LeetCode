package job.tme;

public class RemoveDuplicates_26 {
    /*
        删除有序数组中的重复项
        双指针，类似于喜新厌旧。
        慢指针指向下一个不同元素要填入的下标位置，
        快指针指向遍历数组的下标位置，一旦当前元素和前一个元素不同则填入到慢指针位置
     */
    public int removeDuplicates(int[] nums) {
        // 首先判定数组长度
        int len = nums.length;
        if (len == 0)
            return 0;
        // 不为 0 则至少有一个元素
        // 在删除元素后也至少剩下一个元素，所以快慢指针直接从下标 1 开始
        int slowP = 1;
        int fastP = 1;
        for (; fastP < len; fastP++) {
            // 如果 fastP 找到当前元素和前一个元素相等
            // 将其复制到慢指针
            if (nums[fastP - 1] == nums[fastP]) {
                nums[slowP] = nums[fastP];
                ++slowP;
            }
        }
        // slowP 刚好为最后去掉重复元素的数组长度
        return slowP;
    }
}
