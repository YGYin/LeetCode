package round1.hot100.graph;

public class Exist_79 {
    // 定义方向
    private int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // 记录访问情况
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        // 本质为 DFS 回溯，从起始点往四个方向搜
        // 如果当前方向已经访问过，或者越界，或者不匹配，就回溯
        // 然后往下一个方向搜

        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 只有第一个字符相同才有遍历的必要
                if (board[i][j] == word.charAt(0)) {
                    // 选取当前元素开始遍历
                    visited[i][j] = true;
                    if (dfs(i, j, 1, board, word))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int count, char[][] board, String word) {
        // 如果当前长度等于 word 收集结果
        if (count == word.length())
            return true;
        // 向四个方向遍历
        for (int i = 0; i < 4; i++) {
            int nextRow = row + move[i][0];
            int nextCol = col + move[i][1];
            // 移动后判断边界，是否匹配
            if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length)
                continue;
            // 判断已经访问过或者不匹配
            if (visited[nextRow][nextCol] || board[nextRow][nextCol] != word.charAt(count))
                continue;

            // 标记访问情况，此处回溯
            visited[nextRow][nextCol] = true;
            if (dfs(nextRow, nextCol, count + 1, board, word))
                return true;
            // 不匹配，回溯
            visited[nextRow][nextCol] = false;
        }
        // 四个方向都不匹配
        return false;
    }
}
