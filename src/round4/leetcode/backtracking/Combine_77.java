package round4.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combine_77 {
    // 收集当前路径和结果
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 组合问题，需要 startIndex 避免记录重复组合
        backtracking(1, n, k);
        return res;
    }

    private void backtracking(int startIndex, int n, int k) {
        // 满足条件，此处为当前 path 个数到达 k 时收获结果
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            // 不是子集问题，不需要在非叶子节点收获结果，直接 return
            return;
        }

        // 遍历本层节点，可以剪枝
        // 如果 for 循环选择的起始位置之后的元素个数已经不足所需要的元素个数了，那么就没有必要搜索
        for (int i = startIndex; i <= n - (k - path.size()); i++) {
            // 处理节点，此处直接加入 path，遍历下一层然后回溯
            path.add(i);
            backtracking(i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
