package round2.hot100.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge_56 {
    /*
     * 主要思想：
     * 记得需要按左边界先排序，让区间尽量重合
     * 1. 遇到有重叠的就直接合并，更新 res 数组中当前最后一个元素的右区间
     * 2. 没有重叠直接加入到 res 中
     */
    public int[][] merge(int[][] intervals) {
        // 不知道最终的个数，需要用 list 存
        LinkedList<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 先加入第一个区间到 res 中方便比较
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 比较 res 中最后的右边界和当前区间的左边界，看是否重叠
            // 重叠 更新左右区间，重新加入到 list 中
            if (res.getLast()[1] >= intervals[i][0]) {
                // 右区间取两者较大的
                int start = res.getLast()[0];
                int end = Math.max(res.getLast()[1], intervals[i][1]);
                // 先移除当前 res 中最后一个区间，重新加入更新后的区间
                res.removeLast();
                res.add(new int[]{start, end});
            } else
                res.add(intervals[i]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
