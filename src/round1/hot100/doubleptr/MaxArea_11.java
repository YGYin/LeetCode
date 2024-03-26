package round1.hot100.doubleptr;

public class MaxArea_11 {
    public int maxArea(int[] height) {
        // 初始化双指针分别指向左右隔板
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        // 循环不断收窄左右指针，直到左右指针相遇
        while (left < right)
            // 选定两块板中较短的那块，更新面积最大值，向中间收窄
            res = height[left] < height[right] ?
                    Math.max(res, (right - left) * height[left++]) :
                    Math.max(res, (right - left) * height[right--]);

        return res;
    }
}
