package round1.hot100.binary;

public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 搜索二维矩阵
        // 从右上角看就为类似二叉搜索树，小的都在根节点左边，大的都在根节点右边
        int m = 0;
        int n = matrix[0].length - 1;
        while (m >= 0 && m < matrix.length && n >= 0 && n < matrix[0].length) {
            if (target > matrix[m][n])
                ++m;
            else if (target < matrix[m][n])
                --n;
            else
                return true;
        }
        return false;
    }
}
