package round3.hot100.heap;

import java.util.PriorityQueue;

public class FindKthLargest_215 {
    /*
        数组中的第 K 个最大元素
        用最小堆，维护 K 个元素，最后倒序输出第 k 大元素
     */
    public int findKthLargest(int[] nums, int k) {
        // 已知 k <= nums.length
        if (nums.length == 1)
            return nums[0];

        // 定义小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            // 堆中元素小于 k 个直接加入到小顶堆
            if (pq.size() < k)
                pq.offer(nums[i]);
                // 等于 k 时先和堆顶进行比较，大于堆顶再加入
            else {
                if (!pq.isEmpty() && nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        // 输出第 k 大元素，堆顶最小，最后输出的最大
        int res = 0;
        for (int i = 0; i < pq.size() - k + 1 && !pq.isEmpty(); i++)
            res = pq.poll();

        return res;
    }
}
