package round1.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup_90 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            res.add(path);
            return res;
        }
        // 与组合总和 2 类似，只是变成收获每个子节点，需要先排序
        Arrays.sort(nums);
        // 同样使用 used 数组标记是否使用过
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, 0);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used, int startIndex) {
        // 子集问题收获每个子节点
        res.add(new ArrayList<>(path));
        // 结束条件：遍历到子节点
        if (startIndex >= nums.length)
            return;
        // 单层处理逻辑
        for (int i = startIndex; i < nums.length; i++) {
            // 处理单个节点
            // 如果该节点和前面重复，且为被选取的第一个元素，
            // 说明已经被前面覆盖过，无需选取
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            // 当前节点可用
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, i + 1);
            // 回溯
            path.removeLast();
            used[i] = false;
        }
    }
}
