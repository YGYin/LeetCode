package round1.array;

public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startI = 0;
        int startJ = 0;
        // 循环圈的次数为 n / 2;
        int loop = n / 2;
        // 中间坐标
        int mid = n / 2;
        // 定义偏移量，控制每一条边遍历的长度
        // 每循环一圈时，右边界会收缩一位
        int offset = 1;
        // 定义 i, j
        int i, j;
        // 计数数值
        int count = 1;
        while (loop-- != 0) {
            // 每次转圈开始初始化 i, j 指针
            j = startJ;
            // 上边界：从初始点开始，遍历到倒数第二个，留一条边给下面处理
            for (j = startI; j < n - offset; j++)
                res[startI][j] = count++;
            // 此时 j 位于当前圈的最右侧，向下移动不需改变 j
            // 右边界
            for (i = startI; i < n - offset; i++)
                res[i][j] = count++;
            // 此时 i 位于当前圈的最下侧，向左移动不需改变 i
            // 下边界
            // 注意此处不能直接让 j > 0，边界会变化，应为 j > startJ
            for (; j > startJ; j--)
                res[i][j] = count++;
            // 左边界
            for (; i > startI; i--)
                res[i][j] = count++;

            // 转完一圈后，更新 i 和 j 对应的初始点
            startI++;
            startJ++;
            // offset 内缩
            offset++;
        }
        // 注意 n 为基数的情况，此时最中心需要手动赋值
        if (n % 2 == 1)
            res[mid][mid] = count;
        return res;
    }
}
