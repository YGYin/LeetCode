package round4.leetcode.trick;

public class FindDuplicate_287 {
    /*
        287. 寻找重复数
        为下标 n 和元素 nums[n] 建立映射关系 f(n)
        从下标为 0 出发，根据 f(n) 计算出一个值，
         以这个值为新的下标，再用这个函数计算，
         以此类推，直到下标超界。这样可以产生一个类似链表一样的序列

        然后转变为链表存在环，用快慢指针找到环的入口
        慢指针映射一次，快指针映射两次
     */
    public int findDuplicate(int[] nums) {
        int slowP = 0;
        int fastP = 0;
        slowP = nums[slowP];
        fastP = nums[nums[fastP]];
        while (slowP != fastP) {
            slowP = nums[slowP];
            fastP = nums[nums[fastP]];
        }
        // 相等后，双指针分别指向头部和相等处，各往前走一步，相等处为环入口重复数
        int ptr1 = 0;
        int ptr2 = fastP;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
