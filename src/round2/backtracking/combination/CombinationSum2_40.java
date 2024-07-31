package round2.backtracking.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2_40 {
    /*
        组合总和 II
        该题主要难点在于数组中有重复的元素，同时不能出现重复的组合
        这需要在树层上做去重，在同一层上不选取相同的元素，但在树枝上可以选取数值相同(不是同一个)的元素
        需要用 used 数组来标记使用情况
        只有当 used[i-1] == false && can[i] == can[i-1] 时说明该层元素和前面相同
        - used[i-1] == false 说明是同一层
        - 如果 used【i-1] == true 而且和前一个元素相同，说明在树枝上对数值相同的不同元素进行选取

     */
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 1 && candidates[0] != target)
            return res;
        // 使用 used 数组去重记得需要先对 candidates 排序
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        // 组合问题，startIndex
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        // 如果等于 target 就收获结果返回，大于 target 剪枝直接返回
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target)
            return;

        // 处理当前树层节点，从 startIndex 开始
        for (int i = startIndex; i < candidates.length; i++) {
            // 先对当前树层去重
            if (i > 0 && !used[i - 1] && candidates[i] == candidates[i - 1])
                continue;
            // 标记当前节点已使用
            used[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1, sum + candidates[i]);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
