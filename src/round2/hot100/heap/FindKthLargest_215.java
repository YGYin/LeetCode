package round2.hot100.heap;

import java.util.PriorityQueue;

public class FindKthLargest_215 {
    /*
        数组中的第 K 个最大元素
        用最小堆，维护 K 个元素，最后倒序输出第 k 大元素
     */
    public int findKthLargest(int[] nums, int k) {
        // 题目条件 k <= nums.length
        if (nums.length == 1)
            return nums[0];

        // 最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            // 如果小于 k，直接进队列
            if (pq.size() < k)
                pq.offer(nums[i]);
            else {
                // 看是否大于小顶堆顶点，大于的话先推出顶点再加入
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        // 倒序输出第 k 大元素
        int res = 0;
        for (int i = 0; i < pq.size() - k + 1; i++)
            res = pq.poll();

        return res;
    }
}
