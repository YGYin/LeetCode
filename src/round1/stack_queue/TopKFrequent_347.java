package round1.stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        // 主要解决两个问题
        // 1. 统计元素出现频率 (个数多，出现次数 K-V -> map)
        // 2. 对出现频率进行排序 (维护前 k 个大的元素 -> 小顶堆)
        //      相对于使用快排，k log n <= n log n

        // map 用于记录元素出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // 因为需要返回前 k 个高频的元素，所以需要使用二元组(num, count)来储存
        // 出现次数从小到大(小顶堆)，每次加入新的高频元素 pop 队头
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        // 用 entrySet 遍历 map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 小顶堆只需要维护 k 个元素
            // 当堆元素小于 k 个时，将(num, count)二元组加入到小顶堆中
            if (pq.size() < k)
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                // 看新加入的元素出现频率是不是比小顶堆根节点大，
                // 是的话 pop 根节点，加入新元素
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // 小顶堆中已经从小到大排好序，数组从后往前记录元素
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll()[0];

        return res;
    }
}
