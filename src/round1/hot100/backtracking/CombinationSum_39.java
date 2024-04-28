package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 组合总和，组合问题无序，需要 startIndex 来避免出现选取相同元素的不同排列
        backtracking(candidates, target, 0, 0);
        return res;
    }

    private void backtracking(int[] candidates, int target, int startIndex, int curSum) {
        // 当前和超过 target 时无意义，返回
        if (curSum > target)
            return;
        // 当前和等于 target 时收获结果
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历当前层，避免不同排列出现，从 startIndex 开始
        for (int i = startIndex; i < candidates.length; i++) {
            // 处理当前节点，将当前节点加入到 path 中
            path.add(candidates[i]);
            // 进入到下一层选取元素，因为 candidates 中的同一个数字可以无限制重复被选取
            // 所以当前 startIndex i 不需要 +1，使其可以重复选取当前元素
            backtracking(candidates, target, i, curSum + candidates[i]);
            // 回溯
            path.removeLast();
        }
    }
}
