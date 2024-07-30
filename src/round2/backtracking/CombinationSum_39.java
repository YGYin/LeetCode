package round2.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    /*
        组合总和
        数组中的元素可以多次被选，使用 startIndex 时下一个选取开始的 startIndex 不用 + 1
     */

    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 1 && candidates[0] != target)
            return res;
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int sum) {
        // 当和刚好等于 target 的时收获结果
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 因为全是正数，大于 target 时直接返回
        if (sum > target)
            return;

        // 处理当前层节点
        // 但是需要 i = startIndex 限制同层的后续节点只能从 startIndex 开始选，避免出现重复组合
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            // 因为每次都可以重复选取, startIndex 不需要 + 1
            backtracking(candidates, target, i, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
