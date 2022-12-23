package offer;

public class FindNumberIn2DArray_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int rol = 0, col = n - 1;
        while (rol < m && col >= 0) {
            if (target < matrix[rol][col])
                --col;
            else if (target == matrix[rol][col])
                return true;
            else
                ++rol;
        }
        return false;
    }
}
