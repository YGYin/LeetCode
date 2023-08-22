package coding.back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_04 {
    // 记录结果
    List<List<Integer>> res = new ArrayList<>();
    // 记录路径
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target)
            return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            // sum +-= candidates[i];
            backtracking(candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
