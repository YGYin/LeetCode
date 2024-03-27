package round1.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 传入数组，以及 startIndex 控制其往后取
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 组合问题和分割问题都是收集树的叶子节点，而子集问题是找树的所有节点
        // 所以收获结果放在每次进入递归函数，即终止条件之前
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length)
            return;
        // 单层处理
        for (int i = startIndex; i < nums.length; i++) {
            // 处理节点
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
