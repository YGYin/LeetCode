package round2.doubleptr;

public class RemoveElement_27 {
    /*
        移除元素，快慢指针
        快指针指向待判断的元素，慢指针指向下一个待替换的位置
        快指针一找到不为 target 的元素就赋值到慢指针
        最后返回慢指针
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++)
            if (nums[fast] != val)
                nums[slow++] = nums[fast];

        return slow;
    }
}
