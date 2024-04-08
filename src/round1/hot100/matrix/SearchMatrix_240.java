package round1.hot100.matrix;

public class SearchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int startRow = 0;
        int startCol = matrix[0].length - 1;
        while (startRow < matrix.length && startCol >= 0) {
            if (target > matrix[startRow][startCol])
                ++startRow;
            else if (target < matrix[startRow][startCol])
                --startCol;
            else
                return true;
        }
        return false;
    }
}
