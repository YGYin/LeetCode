package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length < 1)
            return res;

        // 求组合，但是可以重复选取，需要 startIndex 避免不同排列
        // 但需要当前的和
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int curSum, int startIndex) {
        if (curSum > target)
            return;
        // 和等于目标时收获结果
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历当前行，因为可以重复选取，但避免重复组合每次都从 startIndex 开始
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, target, curSum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
