package round2.hot100.graph;

import java.util.Deque;
import java.util.LinkedList;

public class OrangesRotting_994 {
    /*
        腐烂的橘子
        BFS
        加入队列的标记为 2，每遍历一轮 count++
     */

    // 记录访问情况
    boolean[][] visited;
    // 定义方向
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int count = 0;

    public int orangesRotting(int[][] grid) {
        // 初始化 visited
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        // 有可能开始就存在多个 腐烂橘子，在开头先遍历一次 让所有腐烂橘子先进入队列
        // 并统计新鲜橘子个数，方便结束条件
        Deque<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ++fresh;
                else if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
            }
        }

        // bfs，同时记得使用剩余 新鲜橘子个数 来限制循环
        while (fresh > 0 && !queue.isEmpty()) {
            ++count;
            // 因为初始就有多个腐烂橘子，
            // 队列所有腐烂橘子都要感染一次周围橘子，这里需要用 qSize
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {

                int[] cur = queue.poll();
                int curI = cur[0];
                int curJ = cur[1];

                // 向四个方向遍历
                for (int j = 0; j < 4; j++) {
                    int nextI = curI + dir[j][0];
                    int nextJ = curJ + dir[j][1];
                    // 判断是否越界
                    if (nextI < 0 || nextI >= grid.length
                            || nextJ < 0 || nextJ >= grid[0].length)
                        continue;
                    // 符合为新鲜橘子且没有访问则加入队列
                    if (!visited[nextI][nextJ] && grid[nextI][nextJ] == 1) {
                        queue.offer(new int[]{nextI, nextJ});
                        grid[nextI][nextJ] = 2;
                        --fresh;
                    }
                }
            }
        }

        // 因为记录了 fresh，所以直接通过 fresh 看是否还有新鲜橘子，避免再一次完整遍历 grid
        return fresh == 0 ? count : -1;
    }
}
