package round2.stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    /*
        前 K 个高频元素
        1. 先遍历数组，用 map 储存每个元素的出现频率
        2. 维护一个大小为 k 的小顶堆(优先队列, o1 - o2)，遍历 map 将键值对加入到小顶堆中
        3. poll 出小顶堆中的元素，倒序放入答案数组中
     */
    public int[] topKFrequent(int[] nums, int k) {
        // key: 元素  val: 出现频次
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // 定义小顶堆 o1 - o2，类型为 int[]，按频率大小来排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 遍历 map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 看当前小顶堆个数如果小于 k 直接加入
            if (pq.size() < k)
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                // 看当前元素的出现频率是否大于小顶堆栈顶元素的出现频率
                if (!pq.isEmpty() && entry.getValue() > pq.peek()[1]) {
                    // 将顶部元素 poll 出，同时加入新元素到小顶堆中
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // poll 出小顶堆中的元素，倒序放入答案数组中
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll()[0];

        return res;
    }
}
