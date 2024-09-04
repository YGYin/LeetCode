package round2.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllPossiblePath_98 {
    /*
        KAMA_98. 所有可达路径
     */
    static LinkedList<Integer> path = new LinkedList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        // 输入获取 n 和 m
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 新建 graph 矩阵储存图
        // 因为节点编号从 1 到 n，申请 n + 1
        // graph[a][b] = 1 表示从节点 a 到 b 存在路径
        int[][] graph = new int[n + 1][n + 1];

        // 根据 m 根边输入节点 s 和节点 t
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            // 储存到邻接矩阵中
            graph[s][t] = 1;
        }

        // 从节点 1 出发到节点 n
        path.add(1);
        dfs(graph, 1, n);

        // 输出 res
        // res 有可能为空
        if (res.isEmpty())
            System.out.println(-1);

        for (List<Integer> list : res) {
            for (int i = 0; i < list.size() - 1; i++)
                System.out.print(list.get(i) + " ");
            // 换行
            System.out.println(list.get(list.size() - 1));
        }
    }

    // 传入邻接矩阵，当前的节点和终点节点
    public static void dfs(int[][] graph, int cur, int n) {
        // 当当前节点遍历到目标节点时收获结果
        if (cur == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历和当前节点连接的节点
        for (int i = 1; i <= n; i++) {
            // graph[cur][i] = 1 说明 cur 和 i 之间存在路径
            if (graph[cur][i] == 1) {
                // 对当前节点记录到路径中
                path.add(i);
                // 深搜
                dfs(graph, i, n);
                path.removeLast();
            }
        }
    }
}


