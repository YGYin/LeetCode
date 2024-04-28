package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 子集问题没有顺序，意味着不存在不同顺序的排列
        // 需要 startIndex 来控制其每次不往前取
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 子集问题每个树节点都要收集为结果，且同层可能存在其他结果
        // 收集结果后不需要返回
        res.add(new ArrayList<>(path));
        // 只有 startIndex 越界了才需要返回
        if (startIndex >= nums.length)
            return;

        // 处理当前层的节点
        for (int i = startIndex; i < nums.length; i++) {
            // 将当前层的节点加入到 path 中
            path.add(nums[i]);
            // 因为已经选取当前节点，进入下一层需要从下一节点开始
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
