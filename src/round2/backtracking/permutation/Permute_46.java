package round2.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
    /*
        全排列
        主要与组合问题有两大不同 (同样是到叶子节点才收获结果)
        1. 因为有顺序，[1, 2] [2, 1] 为不同组合，每层都是从 0 开始搜索而不是 startIndex
        2. 因为每层从头搜索但每个元素又只能使用一次，所以需要 used 数组记录 path 里已经存放哪些元素
     */
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        // 因为只是记录是否使用过，在树枝上去重，而不是在同一树层去重，所以不需要对 nums 排序
        Arrays.fill(used, false);
        backtracking(nums, used);

        return res;
    }

    private void backtracking(int[] nums, boolean[] used) {
        // 到达叶子节点收获结果
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 处理本层节点
        // 因为每层都要从头搜索，不需要 startIndex，i = 0
        for (int i = 0; i < nums.length; i++) {
            // 如果当前节点已经使用过则跳过
            if (used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
