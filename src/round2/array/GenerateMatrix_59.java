package round2.array;

public class GenerateMatrix_59 {
    /*
        螺旋矩阵 II
     */
    public int[][] generateMatrix(int n) {
        // 需要定义每次的起始 x 位置和 y 位置
        int startX = 0;
        int startY = 0;
        // 偏移量
        int offset = 1;
        // 初始化数组以及计数
        int[][] res = new int[n][n];
        int count = 1;
        // 定义圈数
        int loop = n / 2;

        while (loop > 0) {
            // 固定 startX 和 startY
            int i = startY;
            int j = startX;

            // 上边，从左往右，长度边界由 n - offset 来控制
            for (; j < n - offset; j++)
                res[i][j] = count++;

            // 右边，从上往下，此时 j 已到达最右边
            for (; i < n - offset; i++)
                res[i][j] = count++;

            // 下边，从右往左，此时 i 已到达最下面
            for (; j > startX; j--)
                res[i][j] = count++;

            // 左边，从下往上，此时 j 已到达最左边
            for (; i > startY; i--)
                res[i][j] = count++;

            // 更新 startX 和 startY
            ++startX;
            ++startY;
            // 更新 loop 和 offset
            --loop;
            ++offset;
        }
        // 如果 n 是奇数，中间未被填充
        if (n % 2 == 1)
            res[n / 2][n / 2] = count;

        return res;
    }

}
