package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 子集，[1, 2] 和 [2, 1] 为同一个重复子集，需要 startIndex 防止重复
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 子集需要在每个节点都收获结果，收获完当前结果继续遍历，防止重复
        res.add(new ArrayList<>(path));

        // 遍历当前层
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
