package ds_primer;

public class IsValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] curRow = new int[9][10];
        int[][] curCol = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                // char -> int
                int num = board[i][j] - '0';
                // Exist in current row?
                if (curRow[i][num] == 1)
                    return false;
                // Exist in current col?
                if (curCol[j][num] == 1)
                    return false;
                // Exist in current box?
                if (box[j / 3 + (i / 3) * 3][num] == 1)
                    return false;

                curRow[i][num] = 1;
                curCol[j][num] = 1;
                box[j / 3 + (i / 3) * 3][num] = 1;
            }
        }
        return true;
    }
}
