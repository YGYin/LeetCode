package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        backtracking(nums, used);

        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 当前层
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backtracking(nums, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
