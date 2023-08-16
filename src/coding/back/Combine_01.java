package coding.back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine_01 {
    // 记录结果
    List<List<Integer>> res = new ArrayList<>();
    // 记录单条路径
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    // n: 节点总个数 k: 组合所需个数
    private void backtracking(int n, int k, int startIndex) {
        // 终止条件
        if (path.size() == k) {
            // 存放结果
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            // 处理节点
            path.add(i);
            // 递归
            backtracking(n, k, i + 1);
            // 回溯，撤销处理结果
            path.remove(path.size() - 1);
        }
    }
}
