package round2.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs_99 {
    /*
        KAMA_99. 岛屿数量
        bfs 实现
     */

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void bfs(int[][] graph, boolean[][] visited, int i, int j) {
        // 新建队列，储存下一圈还没访问的节点坐标 (i, j)
        Queue<int[]> queue = new LinkedList<>();
        // 加入当前起始节点，加入节点即为遍历过，在 visited 数组上标记
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        // 遍历队列
        while (!queue.isEmpty()) {
            // 取出要遍历的节点
            int[] curNode = queue.poll();
            int curI = curNode[0];
            int curJ = curNode[1];
            // 以当前节点为起始点 bfs 四个方向
            for (int k = 0; k < 4; k++) {
                // 根据 dir 数组向四个方向移动
                int nextI = curI + dir[k][0];
                int nextJ = curJ + dir[k][1];
                // 当 bfs 遇到边界时则直接 continue
                if (nextI < 0 || nextI >= graph.length || nextJ < 0 || nextJ >= graph[0].length)
                    continue;
                // 如果 bfs 扫描到的节点未访问过且存在路径，则加入到队列中，并标记访问
                if (!visited[nextI][nextJ] && graph[nextI][nextJ] == 1) {
                    queue.offer(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                graph[i][j] = sc.nextInt();

        // 新建 visited 数组
        boolean[][] visited = new boolean[n][m];
        int islandNum = 0;

        // 遍历图，选取 bfs 的起始点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 如果当前这个节点没有遍历过，且为岛屿则岛屿数 + 1
                if (!visited[i][j] && graph[i][j] == 1) {
                    ++islandNum;
                    // 对这个初始点进行 bfs
                    bfs(graph, visited, i, j);
                    System.out.println(Arrays.deepToString(visited));
                }
            }
        }

        System.out.println(islandNum);
    }
}
