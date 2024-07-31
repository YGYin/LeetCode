package round2.backtracking.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup_90 {
    /*
        子集 II
        含有重复的元素，使用 used 数组去重
     */
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 初始化 boolean 数组，填充 false
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        // 使用 used 数组需要先对 nums 数组排序
        Arrays.sort(nums);
        backtracking(nums, used, 0);
        return res;
    }

    private void backtracking(int[] nums, boolean[] used, int startIndex) {
        // 同样先收集结果
        res.add(new ArrayList<>(path));

        if (startIndex == nums.length)
            return;

        // 处理本层节点
        for (int i = startIndex; i < nums.length; i++) {
            // [1, 2, 2]
            // 如果当前元素在之前已经有相同元素做为开头来做子集，可直接剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            // 加入节点，used 数组做标记
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
