package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens_51 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        // 需要记录层数
        backtracking(board, 0);
        return res;
    }

    private void backtracking(char[][] board, int level) {
        // 到达最底一层的时候收获结果
        if (level == board.length) {
            res.add(arrToList(board));
            return;
        }

        // 处理当前层
        for (int i = 0; i < board[0].length; i++) {
            // 放棋子前需要检查皇后是否有冲突
            if (isValid(board, level, i)) {
                // 没有冲突，设置为 Q 到下一层
                board[level][i] = 'Q';
                backtracking(board, level + 1);
                board[level][i] = '.';
            }
        }
    }

    private List<String> arrToList(char[][] board) {
        List<String> curBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String curRow = new String(board[i]);
            curBoard.add(curRow);
        }
        return curBoard;
    }

    // 分别向左上方，正上方，右上方检查是否有冲突，当前层只放一个无需检查
    private boolean isValid(char[][] board, int m, int n) {
        // 遍历左上方
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // 遍历正上方
        for (int i = m - 1; i >= 0; i--)
            if (board[i][n] == 'Q')
                return false;

        // 遍历右上方
        for (int i = m - 1, j = n + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}
