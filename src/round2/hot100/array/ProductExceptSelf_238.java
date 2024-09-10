package round2.hot100.array;

public class ProductExceptSelf_238 {
    /*
     * 除自身以外数组的乘积
     * 主要思想：
     * 1. 分别用两个数组来储存 i 的左边元素的(不包含 i)乘积以及 i 右边元素的乘积
     *      类似定义 dp 数组，lMulti[i] = lMulti[i-1] * nums[i-1]
     *          nums[i] 的（不包括 i）左边乘积 = 不包括 i-1 的左边乘积 * nums[i-1]
     * 2. 这两个数组分别从左开始和从右开始遍历数组，同时首位初始化为 1
     * 3. 对应所求的除 i 以外各元素成绩为 lMulti[i] * rMulti[i]
     */
    public int[] productExceptSelf(int[] nums) {
        // 初始化两个数组用来记录 i 的左右的累积乘积，并初始化
        int[] lMulti = new int[nums.length];
        int[] rMulti = new int[nums.length];
        lMulti[0] = 1;
        rMulti[nums.length - 1] = 1;

        // 分别从左和从右遍历 nums 更新乘积数组
        for (int i = 1; i < nums.length; i++)
            lMulti[i] = lMulti[i - 1] * nums[i - 1];

        for (int i = nums.length - 2; i >= 0; i--)
            rMulti[i] = rMulti[i + 1] * nums[i + 1];

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = lMulti[i] * rMulti[i];

        return res;
    }
}
