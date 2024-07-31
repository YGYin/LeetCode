package round2.backtracking.subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class FindSubsequences_491 {
    /*
        非递减子序列
        [4, 7, 6, 7]
        同样需要在树层上做去重，但因为求原数组的非递增子序列，不能对原数组做排序，所以不能用原来 used[] 的去重逻辑去重
        可以在每层都新建一个 hashSet 或者 used[]，来记录当层的元素使用情况进行去重，不需要回溯因为每一层都会刷新
     */
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        // 每次进来先收获节点，但因为要收获的是非递增子序列，只有 path 长度大于 1 时才能收
        if (path.size() > 1)
            res.add(new ArrayList<>(path));

        // 每次新建 hashSet 用于对当前层去重
        HashSet<Integer> set = new HashSet<>();
        // 处理本层节点
        for (int i = startIndex; i < nums.length; i++) {
            // 当不满足非递减，或者节点在本层节点的前面已经被选作过首节点，则剪枝
            if ((!path.isEmpty() && path.getLast() > nums[i]) || set.contains(nums[i]))
                continue;
            // set 加入该节点，不需回溯
            set.add(nums[i]);
            // path 加入节点并回溯
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
