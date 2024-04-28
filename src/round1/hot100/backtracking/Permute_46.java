package round1.hot100.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 全排列问题，有序，所有不同元素开头的排列都需要被取到
        // -> 不需要 startIndex
        // 没有 startIndex 会导致每次都从数组中第一个元素开始获取
        // 但因为在获得一个排列子安下遍历的过程中，一个排列里一个元素只能使用一次
        // 所以需要 used 数组来标记当前 path 的元素选取情况
        boolean[] used = new boolean[nums.length];
        // 回溯传入遍历数组以及 used 数组
        backtraking(nums, used);
        return res;
    }

    private void backtraking(int[] nums, boolean[] used) {
        // 全排列问题在叶子节点收获结果
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 遍历同层节点
        // 不同元素顺序开头为不同排列，从 0 开始遍历
        for (int i = 0; i < nums.length; i++) {
            // 当前层选取该元素之前需要先看是否被选取
            // 若被选取则尝试选取同层别的节点
            if (used[i])
                continue;
            // 选取该元素，加入到 path 并标记
            used[i] = true;
            path.add(nums[i]);
            backtraking(nums, used);
            // 回溯
            path.removeLast();
            used[i] = false;
        }
    }
}
