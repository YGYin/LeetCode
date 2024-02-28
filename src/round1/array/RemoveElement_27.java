package round1.array;

public class RemoveElement_27 {
    // 暴力
    // O(n^2)   O(1)
    public int removeElement_01(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 发现要移除的元素，全部往前移一位
            if (nums[i] == val) {
                for (int j = i + 1; j < length; j++)
                    nums[j - 1] = nums[j];
                // 数组大小 - 1，且 i 回退一位
                --length;
                --i;
            }
        }
        return length;
    }

    // 双指针
    // 快指针遍历寻找是否存在要移除的元素
    // 忙指针指向更新数组下标的位置
    public int removeElement_02(int[] nums, int val) {
        int slowP = 0;
        for (int fastP = 0; fastP < nums.length; fastP++)
            // 只要不相等就用快指针的元素覆盖慢指针的元素
            // 等于要被删除的元素时，慢指针刚好指向该元素
            // 快指针移到下一个不需删除的元素，然后覆盖慢指针的元素
            if (nums[fastP] != val)
                nums[slowP++] = nums[fastP];

        return slowP;
    }
}
