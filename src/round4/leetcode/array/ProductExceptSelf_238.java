package round4.leetcode.array;

public class ProductExceptSelf_238 {
    /*
        除自身以外数组的乘积
        主要思想：
        1. 分别用两个数组来储存 nums[i] 的左边元素的累乘乘积以及 nums[i] 的右边元素的累乘乘积
        2. 这两个数组分别从左开始和从右开始遍历数组，同时首位初始化为 1
        3. 对应所求的除 i 以外各元素乘积为 lMulti[i] * rMulti[i]
     */
    public int[] productExceptSelf(int[] nums) {
        // 记录 nums[i] 的左边元素的累乘乘积以及 nums[i] 的右边元素的累乘乘积
        int[] leftMulti = new int[nums.length];
        int[] rightMulti = new int[nums.length];
        // leftMulti 的首位和 rightMulti 的末位设为 1
        leftMulti[0] = 1;
        rightMulti[rightMulti.length - 1] = 1;

        // 计算 nums[i] 从左到右的累乘乘积
        for (int i = 1; i < leftMulti.length; i++)
            leftMulti[i] = leftMulti[i - 1] * nums[i - 1];

        // 从右到左
        for (int i = rightMulti.length - 2; i >= 0; i--)
            rightMulti[i] = rightMulti[i + 1] * nums[i + 1];

        // 两个数组对位相乘则为除了该元素的各元素乘积
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++)
            res[i] = leftMulti[i] * rightMulti[i];

        return res;
    }
}
