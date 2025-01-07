package round3.hot100.binary;

public class SearchMatrix_74 {
    /*
     * 搜索二维矩阵
     * 从右上角向左边和下方搜索，类似于二叉搜索树
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 特判
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;

        // 只向下或者向左移动，循环条件维护边界
        while (i < matrix.length && j >= 0) {
            if (target < matrix[i][j])
                --j;
            else if (target > matrix[i][j])
                ++i;
            else
                return true;
        }

        return false;
    }
}
