package round4.leetcode.heap;

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

        // map 记录下每个元素的出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // 构建小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 遍历 map 将元素加入到小顶堆中
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 小顶堆元素个数小于 k 时直接加入
            if (pq.size() < k)
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                // 如果大于等于 k，看频次是否比堆顶大，大于堆顶先 poll 再加入元素
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // 最后遍历 pq，因为小顶堆从小到大输出，要前 k 个高频元素，倒序存入数组中
        int[] res = new int[pq.size()];
        for (int i = pq.size() - 1; i >= 0 && !pq.isEmpty(); i--)
            res[i] = pq.poll()[0];

        return res;
    }
}
