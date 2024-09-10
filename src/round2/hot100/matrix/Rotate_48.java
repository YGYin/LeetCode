package round2.hot100.matrix;

public class Rotate_48 {
    /*
     * 顺时针旋转矩阵
     * 等价于先进行水平线反转，再对对角线进行反转
     */
    public void rotate(int[][] matrix) {
        // 特判判空
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return;

        int m = matrix.length;
        int n = matrix[0].length;

        // 先进行水平翻转，只用遍历到一半即可
        for (int i = 0; i < m / 2; i++)
            for (int j = 0; j < n; j++)
                swap(matrix, i, j, m - i - 1, j);

        // 再进行对角线翻转，翻转不要越过对角线，即 j = i
        for (int i = 0; i < m; i++)
            for (int j = 0; j < i; j++)
                swap(matrix, i, j, j, i);
    }

    void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
