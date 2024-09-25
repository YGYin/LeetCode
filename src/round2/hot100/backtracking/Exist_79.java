package round2.hot100.backtracking;

public class Exist_79 {
    /*
        单词搜索
        类似 bfs，但实际对四个方向进行 dfs 深搜 + 回溯
     */
    // 定义数组向四个方向移动
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 定义 visit 数组
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // 长宽都 > 1 无需判空
        // 初始化 visited 数组
        visited = new boolean[board.length][board[0].length];

        // 遍历数组
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 只有该字符等于目标单词的第一个字符才有必要开始搜
                if (board[i][j] == word.charAt(0)) {
                    // 一旦访问则标记
                    visited[i][j] = true;
                    // 对该字符四个方向 dfs
                    if (dfs(board, i, j, word, 1))
                        return true;
                    // 回溯
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int count) {
        // 当长度等于 length 时收获结果
        if (count == word.length())
            return true;

        // 向四个方向遍历
        for (int k = 0; k < dir.length; k++) {
            int nextI = i + dir[k][0];
            int nextJ = i + dir[k][1];
            // 判断是否越界或者已经访问过或者不等于下一个字符
            if (nextI >= board.length || nextI < 0 ||
                    nextJ >= board[0].length || nextJ < 0 ||
                    visited[nextI][nextJ] || board[nextI][nextJ] != word.charAt(count))
                continue;
            // 如果相等，向下一个字符 dfs
            if (board[nextI][nextJ] == word.charAt(count)) {
                // 先标记
                visited[nextI][nextJ] = true;
                if (dfs(board, nextI, nextJ, word, count + 1))
                    return true;
                // 回溯
                visited[nextI][nextJ] = false;
            }
        }
        return false;
    }
}
