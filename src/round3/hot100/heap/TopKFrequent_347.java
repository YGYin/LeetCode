package round3.hot100.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    /*
        前 K 个高频元素
        先用 map 记录下每个元素的出现频率，
        再构建小顶堆，按出现频率排序，遍历 map 将元素加入到小顶堆中
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length <= 1)
            return nums;

        // map 记录元素出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // 构建小顶堆，根据出现频率排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 遍历 map 将元素加入到 pq 中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 堆元素个数小于 k 时直接加入
            if (pq.size() < k)
                pq.offer(new int[]{entry.getKey(), entry.getValue()});
            else {
                // 等于 k 时，看元素出现频率是否大于堆顶频率，大于才 poll 出堆顶加入元素
                if (!pq.isEmpty() && entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        // 现在储存了前 k 高频元素，频率从小到大，当时返回数组要求从大到小，倒序赋值到数组中
        int[] res = new int[pq.size()];
        for (int i = pq.size() - 1; i >= 0 && !pq.isEmpty(); i--)
            res[i] = pq.poll()[0];

        return res;
    }
}
