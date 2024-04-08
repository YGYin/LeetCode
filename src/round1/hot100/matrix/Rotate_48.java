package round1.hot100.matrix;

public class Rotate_48 {
    public void rotate(int[][] matrix) {
        // 旋转图像，将矩阵旋转 90 度
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] tempMat = new int[row][col];
        // 先遍历一次矩阵，使用辅助矩阵记录所有旋转后的元素
        // 对于矩阵第 i 行的第 j 个元素，旋转后出现在倒数第 i 列的第 j 行
        // 可得到 mat[i][j] -> mat[j][n - i - 1]
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                tempMat[j][col - i - 1] = matrix[i][j];

        // 再遍历辅助矩阵，用辅助矩阵覆盖原矩阵
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                matrix[i][j] = tempMat[i][j];
    }
}
