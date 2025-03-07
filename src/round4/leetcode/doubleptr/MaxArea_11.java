package round4.leetcode.doubleptr;

public class MaxArea_11 {
    /*
        盛最多水的容器
        左右双指针，分别从两边向中间靠拢，每次移动短的那块木板
     */
    public int maxArea(int[] height) {
        // 特判，最小长度为 2
        if (height.length == 2)
            return Math.min(height[0], height[1]);

        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                maxArea = Math.max(maxArea, (right - left) * height[left]);
                ++left;
            } else {
                maxArea = Math.max(maxArea, (right - left) * height[right]);
                --right;
            }
        }
        return maxArea;
    }
}
