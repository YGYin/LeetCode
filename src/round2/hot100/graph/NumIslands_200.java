package round2.hot100.graph;

import java.util.Deque;
import java.util.LinkedList;

public class NumIslands_200 {
    /*
        岛屿数量
        BFS 模板题
     */

    // visited 数组记录访问情况，避免重复访问
    boolean[][] visited;
    // 定义方向
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        // 初始化 visited 数组
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;

        // 遍历岛屿数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只有当前位置未被访问过并且为 1 时，进行 bfs
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ++count;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        // 新建队列储存坐标
        Deque<int[]> queue = new LinkedList<>();
        // 将当前坐标加入到队列中，并立即标记为访问过
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        // 开始遍历队列中的元素
        while (!queue.isEmpty()) {
            // 先取出当前元素
            int[] cur = queue.poll();
            int curI = cur[0];
            int curJ = cur[1];

            // 分别向四个方向遍历
            for (int i = 0; i < 4; i++) {
                int nextI = curI + dir[i][0];
                int nextJ = curJ + dir[i][1];
                // 判断是否越界
                if (nextI < 0 || nextI >= grid.length || nextJ < 0 || nextJ >= grid[0].length)
                    continue;
                // 如果岛屿没访问过，并且为 1，加入队列并标记为已访问
                if (!visited[nextI][nextJ] && grid[nextI][nextJ] == '1') {
                    queue.offer(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }
    }
}
