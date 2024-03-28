package round1.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindSubsequences_491 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        // 与子集 2 有所差别，也是收集每个子节点，但是只收集长度至少为 2 的子节点
        // 同时，需要对树层做去重，不能在同一层取相同值的节点作为开头
        // 可每层遍历前新建 set 记录去重
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 应该收集所有子节点，但有前提长度不小于 1
        if (path.size() > 1)
            res.add(new ArrayList<>(path));

        // 每层遍历前定义 set，用于树层去重
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            // 过滤不需要操作的节点
            // 不递增：小于 path 中的最后一位，path 需要判空
            // 重复的：set 中已经存在
            if ((!path.isEmpty() && path.getLast() > nums[i]) || set.contains(nums[i]))
                continue; // 因为树层同一层还能继续往后取
            // 处理节点，加入 set，加入 path
            set.add(nums[i]);
            path.add(nums[i]);
            // 进入到下一层
            backtracking(nums, i + 1);
            path.removeLast();
            // 因为 set 每层都重新定义，没必要在这回溯
        }
    }
}
