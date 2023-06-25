package coding.stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent1_07 {
    /*
        思想：先用 map 记录下每个元素出现的次数，再用小顶堆维护 k 个元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        if (len == 1)
            return nums;
        // key: 元素值  value: 元素出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        // 在优先队列中存储二元组(num, cnt)，cnt 表示元素值 num 在数组中的出现次数
        // 出现次数按从队头到队尾的顺序是从小到大排，出现次数最低的在队头(相当于小顶堆)
        Queue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 小顶堆元素个数小于 k 个时直接加
            if (pq.size() < k)
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            else {
                // 当前元素出现次数大于小顶堆的根节点（当前k个元素中目前出现次数最少的那个）
                if (entry.getValue() > pq.peek()[1]) {
                    // 弹出队头并加入新的节点
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // 因为小顶堆弹出的一个为前 k 个高频元素中较小一个，所以需倒序新建数组
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--)
            res[i] = pq.poll()[0];

        return res;
    }
}