package round2.backtracking.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    /*
        子集
        子集和组合区别在于，同样没有顺序，一样从 startIndex 开始，但每个子节点都为结果，
        符合要求就收获结果且不直接返回，因为同层需要继续收集结果
        ！空集也是数组可能的子集之一
     */
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 子集问题每次进来先收获结果，第一次可以将空集也加入到结果中
        res.add(new ArrayList<>(path));
        // 到达空节点可以向上返回，可不加，因为 for 本来遍历到 nums.length
        if (startIndex == nums.length)
            return;

        // 处理本层节点
        for (int i = startIndex; i < nums.length; i++) {
            // 将当前节点加入到 path
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
