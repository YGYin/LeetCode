package round2.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens_51 {
    /*
        N 皇后
        棋盘的列数为树的宽度，行数为树的高度，每一行为一层
        1. 放在棋盘前检查其 45 度 90 度和 135 度是否有别的皇后，不需要检查当前行，因为当前层只放一个
     */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] chessboard = new char[n][n];
        // 因为 fill 每次只能 fill 一行，需要遍历 chessboard
        for (char[] chs : chessboard)
            Arrays.fill(chs, '.');
        backtracking(n, 0, chessboard);
        return res;
    }

    // 需要传入当前层数 row 来对当前层插入'Q'，列数直接遍历到 n
    private void backtracking(int n, int row, char[][] chessboard) {
        // 到最后一层说明皇后全部摆放完成
        if (row == n) {
            res.add(arrToList(chessboard));
            return;
        }
        // 对当前层摆放 Q
        for (int col = 0; col < n; col++) {
            // 判断是否合法，合法才摆放
            if (isValid(row, col, n, chessboard)) {
                // 在当前格子摆放皇后
                chessboard[row][col] = 'Q';
                // 进入下一层
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查当前列有无皇后
        for (int i = 0; i < n; i++)
            if (chessboard[i][col] == 'Q')
                return false;

        // 检查 45 度是否有皇后，只要检查右上方即可，下面还没放皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j] == 'Q')
                return false;

        // 检查 135 度是否有皇后，只要检查左上方即可，下面还没放皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++)
            if (chessboard[i][j] == 'Q')
                return false;

        return true;
    }

    // 把二位数组中的每一行转化为 String，加入到 List 中
    private List<String> arrToList(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] chs : chessboard)
            list.add(String.copyValueOf(chs));

        return list;
    }
}
