package array;

public class MaxRotateFunction_396 {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int cur = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            cur += i * nums[i];
        }
        int res = cur;
        for (int i = 0; i < n; ++i) {
            cur += sum - (n * nums[n - i - 1]);
            res = Math.max(res, cur);
        }
        return res;
    }
}
