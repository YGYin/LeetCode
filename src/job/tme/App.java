package job.tme;

public class App {
    public int reArrangeArray(int[] nums) {
        int len = nums.length;
        int count = len;
        if (len == 1)
            return 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < len - 1; j++) {
                    swap(nums, j, j + 1);
                }
                --count;
            }
        }
        return count;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int[][] Matrix(int n) {
        int count = 1;
        int[][] mat = new int[n][n];
        int offset = 0;
        int startX = 0;
        int startY = 0;
        int width = n - 1;
        int roll = n / 2;
        while (roll > 0) {
            startX += offset;
            startY += offset;
            width -= offset;
            // 上边，从左到右
            for (int i = startX; i < width; i++) {
                mat[startY][i] = count++;
                ++startX;
            }
            // 右边，从上到下
            for (int i = startY; i < width; i++) {
                mat[i][startX] = count++;
                ++startY;
            }
            // 底边，从右到左
            for (int i = startX; i > 0; i--) {
                mat[startY][i] = count++;
                --startX;
            }
            // 左边，从左到右
            for (int i = startY; i > 0; i--) {
                mat[i][startX] = count++;
                --startY;
            }
            ++offset;
            --roll;
        }
        if (n % 2 == 1)
            mat[n / 2][n / 2] = n * n;

        return mat;
    }
}
