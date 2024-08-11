package round2.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Merge_56 {
    /*
        与无重叠区间一样都是找重叠区间的个数，区别在于一个缩区间，一个取大的区间
        1. 只要有重叠区间就取两者大的区间，更新右边界后加入 res
        2. 没有重叠区间则直接加入 res
     */
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // 同样按左边界先排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        // 加入第一个作为初始的左右边界
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 因为边界可能一直扩展更新，应该和 list 中最后一个元素的右边界比
            if (intervals[i][0] <= res.getLast()[1]) {
                // 更新左边界和右边界，移除掉旧的左右边界，add 新的左右边界
                int start = res.getLast()[0];
                // 右边界取两者较大的
                int end = Math.max(res.getLast()[1], intervals[i][1]);
                res.removeLast();
                res.add(new int[]{start, end});
            }
            // 如果没有重叠则直接加入到 res 中
            else
                res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
