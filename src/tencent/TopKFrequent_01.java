package tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequent_01 {
    public int[] topKFrequent(int[] nums, int k) {
        // 使用 map 记录每个元素出现次数，key: 元素 val: 出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // 根据 map 中的出现频率正序排列，构建小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        // 遍历 map，先获取其 entrySet
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            pq.offer(entry);
            // 维护 k 个元素
            if (pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        // 此时存了从小到大的前 k 个高频元素，需要倒序遍历存入结果数组
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll().getKey();

        return res;
    }
}
