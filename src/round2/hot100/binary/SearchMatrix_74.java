package round2.hot100.binary;

public class SearchMatrix_74 {
    /*
        搜索二维矩阵
        从右上角向左边和下方搜索，类似于二叉搜索树
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        // 从右上角开始遍历矩阵
        int i = 0;
        int j = matrix[0].length - 1;
        // 只会向左或者向下移动，只需要维护两个边界
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
