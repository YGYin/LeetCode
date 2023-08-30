package tencent;

import java.util.*;

public class TopKFrequent_02 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        // 遍历 words，将对应出现频率储存到 map 中
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);

        // 构建小顶堆
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(((o1, o2) -> {
            // 表达式需要考虑出现次数相同，需要按照字母大小来排列的情况
            if (o1.getValue().equals(o2.getValue()))
                return o2.getKey().compareTo(o1.getKey());
            else
                return o1.getValue() - o2.getValue();
        }));
        // 向堆中加入元素，并维护 k 个元素
        for (Map.Entry<String, Integer> entry : entries) {
            pq.offer(entry);
            if (pq.size() > k)
                pq.poll();
        }
        // pop 出堆中的元素并加入到 res 中
        for (int i = 0; i < k; i++)
            res.add(pq.poll().getKey());
        // 因为小顶堆出现顺序为从小到大，需要将 res 翻转一次处理
        Collections.reverse(res);
        return res;
    }
}
