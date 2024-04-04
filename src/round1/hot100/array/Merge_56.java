package round1.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        // 先按照每个区间的起始断点进行升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 数组有可能有多或者有空余，使用 index 记录
        int[][] res = new int[intervals.length][2];
        int index = 0;
        // 初始化，方便后续处理
        res[0] = intervals[0];
        // 当 res[][1] < intervals[][0] 时，一定不重合，直接复制
        for (int i = 1; i < intervals.length; i++) {
            if (res[index][1] < intervals[i][0])
                res[++index] = intervals[i];
                // 重合时，获取两个数组的最大右区间作为合并右区间
                // 更新时因为没有新增数组，index 无需 ++
            else
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
        }
        // copy 新的数组是因为原来的初始化的 res 数组是最大长度 length，
        // 这样如果存在合并的数组之后，res 就存在了[0,0]这种给的元素不符合要求
        // 所以重新复制一个长度是 index + 1 新的数组是因为 index 是实际元素的下标，
        // 如果变成长度要+1
        return Arrays.copyOf(res, index + 1);
    }
}
