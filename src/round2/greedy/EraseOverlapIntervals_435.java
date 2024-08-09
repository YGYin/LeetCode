package round2.greedy;

import java.util.Arrays;

public class EraseOverlapIntervals_435 {
    /*
        无重叠区间
        求需要移除区间的最小数量，使剩余区间互不重叠
        为了让区间尽可能重叠，需要按区间的左边界从小到大排序
        -> 实际不需要删除区间，只需要统计重叠区间的数量，统计之后更新(缩短)重叠区间的右边界

     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1)
            return 0;
        // 按左区间排序
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);

        int res = 0;
        // 遍历数组
        for (int i = 1; i < intervals.length; i++) {
            // 看当前区间是否和前一个区间有重叠，重叠则统计并收缩右区间
            if (intervals[i][0] < intervals[i - 1][1]) {
                ++res;
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }

        return res;
    }
}
