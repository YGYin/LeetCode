package array;

public class CountBattleships_419 {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length, ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j - 1] == 'X')
                    continue;
                if (board[i][j] == 'X')
                    ++ans;
            }
        }
        return ans;
    }
}
