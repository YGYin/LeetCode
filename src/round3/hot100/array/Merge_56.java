package round3.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge_56 {
    /*
        合并区间
        记得需要按左边界先排序，让区间尽量重合
        1. 遇到有重叠的就直接合并，更新 res 数组中当前最后一个元素的右区间
        2. 没有重叠直接加入到 res 中
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        // 需要先对 intervals 按照左区间进行排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 用 list<int[]> 保存区间，分别为区间的左右界
        List<int[]> res = new LinkedList<>();
        // 先加入第一个方便后续比较
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 如果有重叠区间，使用原来区间的左区间，去两者右区间较大者
            if (intervals[i][0] <= res.get(res.size() - 1)[1]) {
                int start = res.get(res.size() - 1)[0];
                int end = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
                res.remove(res.size() - 1);
                res.add(new int[]{start, end});
            }
            // 没有重叠区间直接加入
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
