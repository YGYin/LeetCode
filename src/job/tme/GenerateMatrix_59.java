package job.tme;

public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        // 定义每一圈的起始点 (在填充变量时不直接改变起始点)
        int startX = 0;
        int startY = 0;
        // 定义偏移量用于控制每圈的每条边的长度
        int offset = 1;
        int loop = n / 2;
        int count = 1;
        while (loop > 0) {
            int i = startY;
            int j = startX;
            // 上边，从左到右，j 到达右边界
            for (; j < n - offset; j++)
                nums[startY][j] = count++;
            // 右边，从上到下，i 到达下边界
            for (; i < n - offset; i++)
                nums[i][j] = count++;
            // 下边，从右到左，j 到达左边界
            for (; j > startX; j--)
                nums[i][j] = count++;
            // 左边，从下到上，i 到达 上边界
            for (; i > startY; i--)
                nums[i][j] = count++;
            // 转完一圈后的边界处理
            // 更新 x 和 y 的起始点
            ++startX;
            ++startY;
            // 更新圈数和偏移量
            --loop;
            ++offset;
        }
        // 如果为奇数的话，中间需要手动填充
        if (n % 2 == 1)
            nums[n / 2][n / 2] = count;

        return nums;
    }
}
