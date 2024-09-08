package round2.hot100.doubleptr;

public class MaxArea_11 {
    /*
     * 盛最多水的容器
     * 双指针分别从左右向中间遍历，高度取矮的那一根，不断更新最大值
     */
    public int maxArea(int[] height) {
        if (height.length == 2)
            return Math.min(height[0], height[1]);
        int left = 0;
        int right = height.length - 1;
        // 记录最大值
        int maxRes = 0;
        while (left < right) {
            // 取矮的那一根作为高
            if (height[left] < height[right]) {
                maxRes = Math.max(maxRes, height[left] * (right - left));
                ++left;
            } else {
                maxRes = Math.max(maxRes, height[right] * (right - left));
                --right;
            }
        }

        return maxRes;
    }
}
