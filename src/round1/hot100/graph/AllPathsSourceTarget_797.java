package round1.hot100.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsSourceTarget_797 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 所有可能出现的路径，从 0 起始点到终点的路径
        // dfs 和回溯一个原理，graph[x][i] 代表节点 x 连接的节点

        // 先将原点加入到路径中
        path.add(0);
        dfs(0, graph);
        return res;
    }

    // 传入当前节点和图本身
    private void dfs(int curNode, int[][] graph) {
        // 结束条件：因为收集从 0 起始点到终点的所有路径
        // 所以当 curNode 为 graph.size() - 1 时收获结果
        if (curNode == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历与当前节点连接的所有相邻节点
        for (int i = 0; i < graph[curNode].length; i++) {
            // 处理当前节点，添加到路径并沿着该节点 dfs 进入到下一层
            int nextNode = graph[curNode][i];
            path.add(nextNode);
            dfs(nextNode, graph);
            // 回溯
            path.removeLast();
        }
    }
}
