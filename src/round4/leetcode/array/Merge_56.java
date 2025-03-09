package round4.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_56 {
    /*
        合并区间
        记得需要按左边界先排序，让区间尽量重合
        为方便处理，用 list<int[]> 保存区间，分别为区间的左右界，先加入第一个区间方便后续做比较
        1. 遇到有重叠的就直接合并，使用原来的左边界，更新 res 数组中当前最后一个元素的右边界
        2. 没有重叠直接加入到 res 中
     */
    public int[][] merge(int[][] intervals) {
        // 特判
        if (intervals.length == 1)
            return intervals;
        // 按照左边界从小到大排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        // 先将第一个存进去方便和后续区间比较
        res.add(intervals[0]);

        // 遍历区间
        for (int i = 1; i < intervals.length; i++) {
            // 从 res 中取出上一个(合并好)的区间
            int[] lastInterval = res.get(res.size() - 1);
            // 判断当前区间左边界和上一个区间右边界是否有重叠
            if (intervals[i][0] <= lastInterval[1]) {
                // 使用原来的左边界，将较大的右边界更新为 res 数组中当前最后一个元素的右边界
                int left = lastInterval[0];
                int right = Math.max(lastInterval[1], intervals[i][1]);
                res.remove(res.size() - 1);
                res.add(new int[]{left, right});
            }
            // 没有重叠，直接加入
            else
                res.add(intervals[i]);
        }

        // 将 list 转换为数组
        return res.toArray(new int[res.size()][2]);
    }
}
