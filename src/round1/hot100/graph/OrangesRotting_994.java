package round1.hot100.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class OrangesRotting_994 {
    // 记录是否已访问
    boolean[][] visited;
    // 定义移动方向
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        // 腐烂的橘子，染色 bfs 模板
        int minute = 0;
        visited = new boolean[grid.length][grid[0].length];
        int fresh = 0;

        // 辅助队列
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 统计新鲜橘子个数
                if (grid[i][j] == 1)
                    ++fresh;
                // 腐烂橘子全入队列 (需要感染往外扩的全入对列)
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }

        // 遍历队列
        while (fresh > 0 && !queue.isEmpty()) {
            ++minute;
            // 队列中所有腐烂橘子都要感染一次周围橘子
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                // poll 元素
                int[] cur = queue.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                // 分别向四个方向遍历
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + move[j][0];
                    int nextCol = curCol + move[j][1];
                    // 判断边界
                    if (nextRow < 0 || nextRow == grid.length || nextCol < 0 || nextCol == grid[0].length)
                        continue;
                    // 只要感染的地方是新鲜橘子就标记为腐烂，并入队
                    if (grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        queue.offer(new int[]{nextRow, nextCol});
                        --fresh;
                    }
                }
            }
        }

        return fresh > 0 ? -1 : minute;
    }

    private void bfs(int[][] grid, int row, int col, int minute) {
        // 辅助队列
        Deque<int[]> queue = new ArrayDeque<>();
        // 将当前起始点加入到队列中
        queue.offer(new int[]{row, col});
        // 标记访问
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            // poll 一个元素
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            // 分别向四个方向遍历
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + move[i][0];
                int nextCol = curCol + move[i][1];
                // 判断边界
                if (nextRow < 0 || nextRow == grid.length || nextCol < 0 || nextCol == grid[0].length)
                    continue;
                // 如果橘子未腐烂，将其标记为腐烂并加入队列
                if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                    grid[nextRow][nextCol] = '2';
                    queue.offer(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = true;
                }
            }
            // 每分钟四个方向移动，更新 minute
            ++minute;
        }
    }
}
