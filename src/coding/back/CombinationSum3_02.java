package coding.back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3_02 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, 1, 0, n);
        return res;
    }

    private void backTracking(int k, int startIndex, int sum, int targetSum) {
        // 剪枝
        if (path.size() > k)
            return;
        if (sum > targetSum)
            return;
        // 终止条件，储存结果
        if (sum == targetSum && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backTracking(k, i + 1, sum, targetSum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
