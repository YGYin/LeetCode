package array;

public class RunningSum_1480 {
    public int[] runningSum(int[] nums) {
        int n = nums.length, sum = 0;
        if (n == 1)
            return nums;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            res[i] = sum;
        }
        return res;
    }
}
