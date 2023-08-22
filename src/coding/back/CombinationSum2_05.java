package coding.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_05 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
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
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])
                continue;
            path.add(candidates[i]);
            used[i] = true;
            // sum += candidates[i]; i++;
            backtracking(candidates, target, sum + candidates[i], i + 1);
            // sum -= candidates[i]; i--
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
