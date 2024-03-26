package round1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int curSum) {
        if (curSum > target)
            return;
        // 等于 target 时收获结果
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 单层遍历逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            // 单个节点处理逻辑，将该节点加入到 path 中，并且回溯更新 curSum
            path.add(candidates[i]);
            // 进入到下一层，因为此处可以无限重复选取同一个数字，
            // 进入下一层时 startIndex 无需指向下一位
            backtracking(candidates, target, i, curSum + candidates[i]);
            // 回溯
            path.removeLast();
        }
    }
}
