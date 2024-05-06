package round1.hot100.heap;

import java.util.PriorityQueue;

public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        // 数组中的第 K 个最大元素
        // 1. 第 k 大，维护一个大小为 K 的小顶堆
        // 2. 只要堆大小大于 K，就 poll 元素，剩余的就是第 K 个最大元素

        // o1 - o2: 升序 -> 小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k)
                pq.poll();
        }
        // 剩余 k 个元素，堆顶就是第 k 大元素
        return pq.peek();
    }
}
