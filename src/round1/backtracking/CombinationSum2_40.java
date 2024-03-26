package round1.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 与组合总和_39 区别在于，本体所给数组里面有重复元素
        // 同时要求求出的组合需要去重（可选取不同位置但值相同的元素）
        // 树层去重的话，需要对数组排序！方便后续剪枝判断是否用过该元素
        Arrays.sort(candidates);
        // 用于标记元素是否被选取过
        boolean[] used = new boolean[candidates.length];
        backtracking(candidates, target, used, 0, 0);
        return res;
    }

    // 时间复杂度: O(n * 2^n)
    private void backtracking(int[] candidates, int target, boolean[] used, int startIndex, int curSum) {
        // 剪枝
        if (curSum > target)
            return;
        // == target 时收获结果
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历该层，因为要对树层去重，所以去重逻辑在 for 内
        for (int i = startIndex; i < candidates.length; i++) {
            // e.g [1, 1, 2, 1]
            // 如果选取的是第一个 1，其分支已经包含了选取第二个 1 的后续情况
            // 所以需要对重复的第二个元素去重
            // 防止越界，当前位置和前一位相等，
            // 且第一个 1 未被选取，说明不是第一个 1 的分支
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])
                continue;
            // 处理单个节点，标记节点已使用，加入 path，更新 sum 回溯
            used[i] = true;
            path.add(candidates[i]);
            // 因为当前元素不能重复选取，所以 startIndex + 1
            backtracking(candidates, target, used, i + 1, curSum + candidates[i]);
            // 回溯
            used[i] = false;
            path.removeLast();
        }
    }
}
