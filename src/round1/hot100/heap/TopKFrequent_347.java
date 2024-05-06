package round1.hot100.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            前 k 个高频元素
            1. 遍历一遍数组，用 map 记录每个元素的出现频率
            2. 维护一个大小为 k 的小顶堆，大于 k 时 poll，剩余的为第 k 高频率
            (小于 k 直接加入，大于等于 k 先判断是否大于栈顶，是的话先 poll 再 add)
         */
        // k: 元素    v: 出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // 维护一个小顶堆，因为加入的为数组，重写 compare
        // 通过频率来升序排序实现小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        // 遍历 map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k)
                pq.poll();
        }
        // 因为小顶堆剩余的前 k 个高频元素，按频率从小到大排列
        // 输出要求从大到小排列，倒序输出到数组
        int qSize = pq.size();
        int[] res = new int[qSize];
        for (int i = qSize - 1; i >= 0; i--)
            res[i] = pq.poll()[0];

        return res;
    }
}
