package round3.hot100.matrix;

public class Rotate_48 {
    /*
     * 顺时针旋转矩阵
     * 等价于先进行水平线反转，再对对角线进行反转
     */
    public void rotate(int[][] matrix) {
        // 判空
        if (matrix.length < 1 || matrix[0].length < 1)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        // 水平翻转，只用到遍历到一半
        for (int i = 0; i < m / 2; i++)
            for (int j = 0; j < n; j++)
                swap(matrix, i, j, m - i - 1, j);

        // 对角线翻转，不超过对角线，即 j = i
        for (int i = 0; i < m; i++)
            for (int j = 0; j < i; j++)
                swap(matrix, i, j, j, i);
    }

    private void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = temp;
    }
}
