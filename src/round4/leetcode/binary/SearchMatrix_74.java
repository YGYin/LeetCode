package round4.leetcode.binary;

public class SearchMatrix_74 {
    /*
        搜索二维矩阵
        从右上角向左边和下方搜索，类似于二叉搜索树
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1)
            return false;

        // 定义指针从右上角开始搜索
        int i = 0, j = matrix[0].length - 1;
        // 维护边界条件
        while (i < matrix.length && j >= 0) {
            if (target < matrix[i][j])
                --j;
            else if (target == matrix[i][j])
                return true;
            else
                ++i;
        }
        return false;
    }
}
