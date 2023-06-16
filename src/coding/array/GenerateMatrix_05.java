package coding.array;

public class GenerateMatrix_05 {
    /*
        左闭右开原则，确定每次都处理每条边的第一个到倒数第二个节点
        n / 2 为所需遍历的圈数，类比正方形
        时间复杂度 O(n^2): 模拟遍历二维矩阵的时间
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int loop = 0;
        int count = 1;
        // 每次循环起始点为 (start, start)
        int start = 0;
        int row, col;
        while (loop++ < n / 2) {
            // 上侧从左往右遍历
            for (col = start; col < n - loop; col++)
                res[start][col] = count++;
            // 右侧从上往下遍历
            for (row = start; row < n - loop; row++)
                res[row][col] = count++;
            // 下侧从右往左遍历
            for (; col >= loop; col--)
                res[row][col] = count++;
            // 左侧从下往上遍历
            for (; row >= loop; row--)
                res[row][col] = count++;
            ++start;
        }
        if (n % 2 == 1)
            res[start][start] = count;

        return res;
    }
}
