package round1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 全排列问题与组合问题区别在于，全排列问题收集的路径元素有顺序
        // 组合： [1, 2]  排列: [1, 2], [2, 1]
        // 在收集元素时，不再依赖于 startIndex，用 used 数组来标记使用情况
        // 同时，在叶子节点收获结果
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        // 当到达叶子节点时收集结果，长度等于 nums
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 单层处理逻辑
        // 因为不同元素顺序开头为不同排列，所以 i 从 0 开始
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素已经被取过了，跳过，继续在本层取别的元素
            if (used[i])
                continue;
            // 标记节点，将节点加入到 path 中
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            // 回溯
            path.removeLast();
            used[i] = false;
        }
    }
}
