package coding.array;

public class MinSubArrayLen_04 {
    /*

        时间复杂度：O(n)，每个元素滑进窗口操作一次，出去一次，2n
        空间复杂度：O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int i = 0;
        // j 为滑动窗口每次的结束位置
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                // 获取当前子序列长度并更新最短长度，再更新窗口起始位置 i 以及 sum 的值
                int subLen = j - i + 1;
                res = Math.min(res, subLen);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
