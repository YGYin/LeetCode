package round2.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique_47 {
    /*
        全排列 II
        nums 中有重复数字，返回不重复的全排列，实质上避免选择相同的首元素，需要在树层上去重
        -> 也需要用 used 数组在树层上去重（需要先排序），但因为全排列所以不需要 startIndex
        -> 同时要在树枝上去重，在一个排列内每个元素只能选取一次
     */
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        // 因为要在树层上去重，需要先排序
        Arrays.sort(nums);

        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        // 在叶子节点收获结果
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 处理本层节点
        // 全排列，每次从头开始选
        for (int i = 0; i < nums.length; i++) {
            // 对树层上去重，防止在同一层选取相同首元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            // 同时要在树枝上去重，在一个排列内每个元素只能选取一次
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
