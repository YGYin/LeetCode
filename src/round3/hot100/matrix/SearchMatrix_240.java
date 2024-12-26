package round3.hot100.matrix;

public class SearchMatrix_240 {
    /*
        搜索二维矩阵 II
        从右上角开始，类似于二叉搜索树进行搜索
        循环跳出条件为越界
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // 矩阵判空
        if (matrix.length < 1 || matrix[0].length < 1)
            return false;

        // 定义指针，从右上角开始搜索
        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (target == matrix[i][j])
                return true;
            else if (target > matrix[i][j])
                ++i;
            else
                --j;
        }
        return false;
    }
}
