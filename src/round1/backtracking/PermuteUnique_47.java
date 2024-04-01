package round1.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique_47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 全排列 2 相对于 1 加入了重复元素
        // 同样需要在同一树层上做去重，
        // 如果同一层的前一个树枝已经取过同样元素则 continue
        // 去重前要排序，否则无法去重同层的前一个树枝的相同元素
        Arrays.sort(nums);
        // 定义 used 数组用于去重
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        // 全排列问题在叶子节点收割
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 单层处理逻辑
        // 排列问题有顺序，可以取不同开头，从 i = 0 开始
        for (int i = 0; i < nums.length; i++) {
            // 去重，同层前一个树枝和当前子节点相同
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue; // 继续在同层查找元素
            // 全排列选择当前没有用过的节点
            if (used[i])
                continue;
            // 单层处理及诶点
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used);
            path.removeLast();
            used[i] = false;
        }
    }
}

