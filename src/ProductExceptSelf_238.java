public class ProductExceptSelf_238 {
    /*
        Array nums： [1       2       3       4]
        Left Part：   1       1      1*2    1*2*3
        Right Part：2*3*4    3*4      4       1
        Result：    1*2*3*4  1*3*4   1*2*4  1*2*3*1
     */
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int[] leftRes = new int[nums.length];
        int[] rightRes = new int[nums.length];
        leftRes[0] = left;
        rightRes[nums.length - 1] = right;
        for (int i = 0; i < nums.length - 1; ++i) {
            left *= nums[i];
            leftRes[i + 1] = left;
        }
        for (int i = nums.length - 1; i > 0; --i) {
            right *= nums[i];
            rightRes[i - 1] = right;
        }
        for (int i = 0; i < nums.length; ++i)
            nums[i] = leftRes[i] * rightRes[i];

        return nums;
    }

    public int[] productExceptSelf_2(int[] nums) {
        int left = 1, right = 1;
        int[] res = new int[nums.length];
        res[0] = left;

        for (int i = 0; i < nums.length - 1; ++i) {
            left *= nums[i];
            res[i + 1] = left;
        }
        for (int i = nums.length - 1; i > 0; --i) {
            right *= nums[i];
            res[i - 1] *= right;
        }

        return res;
    }
}
