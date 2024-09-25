package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    /*
        组合总和
        返回满足的组合，但是可以重复选取当前节点或者后面的节点，不能重复选取之前的节点
        需要 startIndex，每次从 i 开始不需要 + 1
     */
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, 0, target);
        return res;
    }

    void backtracking(int[] nums, int startIndex, int curSum, int target) {
        // 剪枝
        if (curSum > target)
            return;
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 处理本层节点，当前节点可以重复选取当前元素，但下一层不能选取比自己小的元素
        // 并且因为是组合，不是排列，需要 startIndex，每次从 i 开始但不需要 + 1
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i, curSum + nums[i], target);
            path.remove(path.size() - 1);
        }
    }
}
