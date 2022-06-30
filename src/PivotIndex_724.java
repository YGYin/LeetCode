public class PivotIndex_724 {
    // Brute Force
    public int pivotIndex(int[] nums) {
        for (int index = 0; index < nums.length; ++index) {
            int left = 0, right = 0;
            for (int lPtr = 0; lPtr < index; ++lPtr)
                left += nums[lPtr];
            for (int rPtr = index + 1; rPtr < nums.length; ++rPtr)
                right += nums[rPtr];
            if (left == right)
                return index;
        }
        return -1;
    }

    public int pivotIndex_2(int[] nums) {
        int preSum = 0;
        for (int num : nums) preSum += num;

        int left = 0;
        for (int index = 0; index < nums.length; ++index) {
            // If left sum == right sum
            // S5 - S2 = a3 + a4 + a5
            if (left == (preSum - left - nums[index]))
                return index;
            left += nums[index];
        }

        return -1;
    }

    public static void main(String[] args) {
        PivotIndex_724 pivotIdx = new PivotIndex_724();
        int[] arr = {1, 7, 3, 6, 5, 6};
        int result = pivotIdx.pivotIndex(arr);
        System.out.println(result);
    }
}
