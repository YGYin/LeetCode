package coding.array;

public class RemoveElement_02 {
    /*
        1. 暴力
            找到对应元素，后面元素全部往前移动一位；
            移动后保持下标不变，接着数组长度减 1

        时间复杂度：O(n^2)，最坏情况下所有元素都等于 val 都后移
        空间复杂度：O(1)
     */
    public int removeElement(int[] nums, int val) {
        int arrLen = nums.length;
        for (int i = 0; i < arrLen; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < arrLen; j++)
                    nums[j - 1] = nums[j];
                --i;
                --arrLen;
            }
        }
        return arrLen;
    }

    /*
        2. 双指针
            用快慢指针，快指针负责遍历数组，慢指针用于更新新数组所需元素；
            与 val 不相等为新数组所需元素，更新慢指针

        时间复杂度：O(n)，遍历一次数组
        空间复杂度：O(1)，双指针常数级空间
     */
    public int removeElement_2(int[] nums, int val) {
        int slowP = 0;
        for (int fastP = 0; fastP < nums.length; fastP++) {
            if (nums[fastP] != val)
                nums[slowP++] = nums[fastP];
        }
        return slowP;
    }
}
