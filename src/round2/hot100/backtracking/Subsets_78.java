package round2.hot100.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    /*
        子集
     */
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // res.add(new ArrayList<>());
        // 子集在下一层不收集当前位置之前的元素，需要 startIndex
        backtracking(nums, 0);
        return res;
    }

    void backtracking(int[] nums, int startIndex) {
        // 子集收集每个节点，收集完后不需要 return
        res.add(new ArrayList<>(path));

        // 处理本层节点
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
