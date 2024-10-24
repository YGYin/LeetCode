package round3.hot100.doubleptr;

public class MaxArea_11 {
    /*
     * 盛最多水的容器
     * 双指针，分别从两边向中间靠拢，每次移动短的那块木板
     */
    public int maxArea(int[] height) {
        if (height.length == 2)
            return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                maxWater = Math.max(maxWater, height[left] * (right - left));
                ++left;
            } else {
                maxWater = Math.max(maxWater, height[right] * (right - left));
                --right;
            }
        }

        return maxWater;
    }
}
