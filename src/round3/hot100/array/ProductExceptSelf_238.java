package round3.hot100.array;

public class ProductExceptSelf_238 {
    /*
        除自身以外数组的乘积
        主要思想：
        1. 分别用两个数组来储存 nums[i] 的左边元素的累乘乘积以及 nums[i] 的右边元素的累乘乘积
        2. 这两个数组分别从左开始和从右开始遍历数组，同时首位初始化为 1
        3. 对应所求的除 i 以外各元素成绩为 lMulti[i] * rMulti[i]
     */
    public int[] productExceptSelf(int[] nums) {
        // 用于记录 nums[i] 的左边和右边元素累乘结果
        int[] leftMulti = new int[nums.length];
        int[] rightMulti = new int[nums.length];
        // 将 left 首位和 right 末尾初始化为 1
        leftMulti[0] = 1;
        rightMulti[nums.length - 1] = 1;

        // 分别从左遍历和从右遍历更新累乘数组
        for (int i = 1; i < nums.length; i++)
            leftMulti[i] = leftMulti[i - 1] * nums[i - 1];

        for (int i = nums.length - 2; i >= 0; i--)
            rightMulti[i] = rightMulti[i + 1] * nums[i + 1];

        // 将 left 和 right 累乘数组相乘记录到 res 中
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            res[i] = leftMulti[i] * rightMulti[i];

        return res;
    }
}
