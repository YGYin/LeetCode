package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens_51 {
    List<List<String>> res = new ArrayList<>();

    // 不需要 path
//    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        // n 皇后 -> 回溯
        /*
            可以把棋盘的二位数组想象为一棵树，每行为一层，每次递归下到下一层
            同时每行只在满足条件的地方摆皇后
            在叶子节点收获结果
         */
        // 首先根据提议将棋盘铺满 '.'
        char[][] chessboard = new char[n][n];
        for (char[] charRow : chessboard)
            Arrays.fill(charRow, '.');
        // 需要传入 n，当前 row (深度)，以及棋盘
        backtracking(n, 0, chessboard);
        return res;
    }

    private void backtracking(int n, int curRow, char[][] chessboard) {
        // 在叶子节点收获结果，遍历到叶节点表示放下了 n 颗皇后
        // 不需要 path，
        // 只需要遍历到子节点时，将当前 chessboard 数组转化为 List<String>
        if (curRow == n) {
            res.add(arrayToList(chessboard));
            return;
        }
        // 遍历当前行
        for (int curCol = 0; curCol < n; curCol++) {
            if (isValid(curRow, curCol, n, chessboard)) {
                // 如果满足条件则在当前位置摆放皇后
                chessboard[curRow][curCol] = 'Q';
                // 进入下一层
                backtracking(n, curRow + 1, chessboard);
                // 回溯
                chessboard[curRow][curCol] = '.';
            }
        }
    }

    private List<String> arrayToList(char[][] chessboard) {
        List<String> curBoard = new ArrayList<>();
        for (char[] charRow : chessboard)
            curBoard.add(String.copyValueOf(charRow));
        return curBoard;
    }

    private boolean isValid(int curRow, int curCol, int n, char[][] chessboard) {
        // 因为每行只摆放一个，不用检查行
        // 同时，只需要检查上方，当前层和下方都仍然未摆放皇后
        // 检查列
        for (int i = 0; i < curRow; i++)
            if (chessboard[i][curCol] == 'Q')
                return false;

        // 检查当前位置的左上方
        for (int i = curRow - 1, j = curCol - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j] == 'Q')
                return false;

        // 检查右上方
        for (int i = curRow - 1, j = curCol + 1; i >= 0 && j < n; i--, j++)
            if (chessboard[i][j] == 'Q')
                return false;

        return true;
    }
}
