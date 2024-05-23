package round1.dp;

public class FindLength_718 {
    /*
        最长重复子数组: 返回两个公共长度最长的子数组的长度（连续）
        1. dp[i][j]:
            表示以 nums1[i - 1] 结尾和 以 nums2[i - 1] 结尾的最大重复子数组的长度
            这种表示方法方便初始化，dp[0][j] = dp[i][0] = 0，剩下交给递推公式
            如果 i j 一一对应实际 i j 结尾位置，
            dp[i][0] 和 dp[0][j] 需要先分别扫一遍两个数组来进行初始化
        2. 递推公式:
            if(nums1[i - 1] == nums2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1
            换言之，当前状态都由左上角得来
        3. 初始化
            dp[0][j] = dp[i][0] = 0
        4. 遍历顺序: 从左到右
     */
    public int findLength(int[] nums1, int[] nums2) {
        // 初始化 dp 数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        // 从 [1, 1] 开始
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                // 需要遍历二维 dp 数组取最大值
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
