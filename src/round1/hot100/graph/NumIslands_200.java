package round1.hot100.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumIslands_200 {
    // 用于标记已经访问过的节点，避免重复访问
    boolean[][] visited;
    // 定义向四个不同方向移动
    int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        // 岛屿数量 200
        // 本质为 bfs 染色
        int count = 0;
        // 根据地图大小初始化 visited 数组
        visited = new boolean[grid.length][grid[0].length];
        // 对每一个格子 bfs
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    // 遍历当前岛屿看能拓展到多大
                    bfs(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int row, int col) {
        // int[] 保存对应(row, col)坐标
        Deque<int[]> queue = new ArrayDeque<>();
        // 将当前起始点加入到队列中
        queue.offer(new int[]{row, col});
        // 坐标一旦加入到队列中就要标记为访问过
        visited[row][col] = true;
        // 开始遍历队列
        while (!queue.isEmpty()) {
            // 从队列中获取元素，并获取其坐标
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            // 用当前节点向四个方向遍历
            for (int i = 0; i < 4; i++) {
                int nextRow = curRow + move[i][0];
                int nextCol = curCol + move[i][1];
                // 移动完后，判断坐标是否越界，越界了就跳过
                if (nextRow < 0 || nextRow == grid.length || nextCol < 0 || nextCol == grid[0].length)
                    continue;
                // 如果节点未被访问过，且为标记为 1 的岛屿，加入队列
                if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] == '1') {
                    queue.offer(new int[]{nextRow, nextCol});
                    // 一加入队列就要标记为访问过，避免重复加入到队列中
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}
