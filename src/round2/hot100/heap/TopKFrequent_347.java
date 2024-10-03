package round2.hot100.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    /*
        前 K 个高频元素
        先用 map 记录下每个元素的出现频率，
        再构建小顶堆，按出现频率排序，将元素加入到小顶堆中
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1)
            return nums;

        // map:  key: 元素  val: 出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // 构建小顶堆，类型为 int[]，根据出现频率排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 遍历 map 加入到小顶堆中
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            // 如果堆中个数小于 k，直接加入
            if (pq.size() < k)
                pq.offer(new int[]{entrySet.getKey(), entrySet.getValue()});
            else {
                // 看是否大于小顶堆顶点
                if (entrySet.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[]{entrySet.getKey(), entrySet.getValue()});
                }
            }
        }

        // 倒序输出
        int[] res = new int[pq.size()];
        for (int i = pq.size() - 1; i >= 0; i--)
            res[i] = pq.poll()[0];

        return res;
    }
}
