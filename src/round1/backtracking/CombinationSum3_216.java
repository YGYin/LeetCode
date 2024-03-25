package round1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3_216 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1, 0);
        return res;
    }

    private void backtracking(int k, int targetSum, int startIndex, int sum) {
        // 剪枝
        if (sum > targetSum || path.size() > k)
            return;
        // 收集结果，path.size 为 k 且和为 targetSum
        if (path.size() == k) {
            if (sum == targetSum)
                res.add(new ArrayList<>(path));
            return;
        }
        // 单层处理逻辑
        for (int i = startIndex; i <= 9; i++) {
            // 当前节点加入到 path 中
            path.add(i);
            // 获取下一层节点，startIndex + 1，sum 加上当前节点值
            backtracking(k, targetSum, i + 1, sum + i);
            // 回溯
            path.removeLast();
        }
    }
}
