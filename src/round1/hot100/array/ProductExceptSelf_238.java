package round1.hot100.array;

public class ProductExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // 左右两侧的乘积列表
        int[] lMulti = new int[len];
        int[] rMulti = new int[len];

        int[] res = new int[len];
        // 初始化 l[0] 为 1
        // l[i] 为索引 i 左侧所有元素的乘积
        lMulti[0] = 1;
        for (int i = 1; i < len; i++)
            lMulti[i] = nums[i - 1] * lMulti[i - 1];
        // 同理，初始化 r[0] 为 1
        // r[i] 索引 i 右侧所有元素的乘积
        rMulti[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--)
            rMulti[i] = nums[i + 1] * rMulti[i + 1];

        // 对应索引 i，除了nums[i] 外
        // 其余元素的乘积就是左侧所有元素的乘积乘于右侧所有元素乘积
        for (int i = 0; i < len; i++)
            res[i] = lMulti[i] * rMulti[i];

        return res;
    }
}
