package round2.hot100.matrix;

public class SearchMatrix_240 {
    /*
        搜索二维矩阵
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j])
                ++i;
            else if (target < matrix[i][j])
                --j;
            else
                return true;
        }

        return false;
    }
}
