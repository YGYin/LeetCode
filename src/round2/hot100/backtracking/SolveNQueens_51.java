package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens_51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 根据 n 初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++)
            Arrays.fill(board[i], '.');

        backtracking(board, 0, n);
        return res;
    }

    private void backtracking(char[][] board, int level, int n) {
        // 到达底部说明全部王后都摆放完成
        if (level == n) {
            res.add(arrToList(board));
            return;
        }

        // 遍历本层，每次从当前层的第一个开始尝试摆放
        for (int i = 0; i < n; i++) {
            if (isValid(board, level, i)) {
                board[level][i] = 'Q';
                // 到下一层的棋盘
                backtracking(board, level + 1, n);
                board[level][i] = '.';
            }
        }
    }

    // 检查当前位置翻皇后的合法性
    private boolean isValid(char[][] board, int m, int n) {
        // 因为一层只会摆放一个棋子，不需要检查水平方向
        // 检查左上角
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;


        // 检查正上方
        for (int i = m - 1; i >= 0; i--)
            if (board[i][n] == 'Q')
                return false;

        // 检查右上角
        for (int i = m - 1, j = n + 1; i >= 0 && j < board[0].length; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    private List<String> arrToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] row : board)
            list.add(String.copyValueOf(row));

        return list;
    }
}
