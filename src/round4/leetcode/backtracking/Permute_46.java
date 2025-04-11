package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permute_46 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1)
            return res;

        // 全排列，used 记录使用状况
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);

        return res;
    }

    void backtracking(int[] nums, boolean[] used) {
        // 到达叶子节点收获结果
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历本层，因为要重复使用，并且需要获取不同顺序，直接从 0 开始
        for (int i = 0; i < nums.length; i++) {
            // 在当前路径（树枝）上没有被使用才能选取
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
