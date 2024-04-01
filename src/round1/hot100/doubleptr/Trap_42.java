package round1.hot100.doubleptr;

public class Trap_42 {
    public int trap(int[] height) {
        // 头尾柱子不接雨水
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        // 记录每个柱子的左边最高柱子高度 maxLeft
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++)
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);

        // 记录每个柱子的右边最高柱子高度 maxRight
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--)
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);

        // 按列求，每列宽度为 1
        // 雨水高度 h = min(lHeight, rHeight)-curHeight
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curHeight = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (curHeight > 0) sum += curHeight;
        }
        return sum;
    }
}
