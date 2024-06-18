package round2.array;

public class RemoveElement_27 {
    /*
        移除元素，快慢指针
        快指针指向待判断的元素，慢指针指向下一个待替换的位置
        最后返回慢指针
     */
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        if (nums.length == 0)
            return 0;
        int slowP = 0, fastP = 0;
        for (; fastP < nums.length; fastP++) {
            // 找到不等于 target 的就往前面放
            if (nums[fastP] != val)
                nums[slowP++] = nums[fastP];

        }
        return slowP;
    }
}
