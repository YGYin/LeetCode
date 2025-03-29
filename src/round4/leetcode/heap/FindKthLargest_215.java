package round4.leetcode.heap;

import java.util.PriorityQueue;

public class FindKthLargest_215 {
    /*
        数组中的第 K 个最大元素
        用最小堆，维护 K 个元素，最后倒序输出第 k 大元素
     */
    public int findKthLargest(int[] nums, int k) {
        // 特判，题目已给 k < nums.length
        if (nums.length == 1)
            return nums[0];
        // 定义小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int i = 0; i < nums.length; i++) {
            // 堆内元素小于 k 个时直接加入
            if (pq.size() < k)
                pq.add(nums[i]);
            else {
                // 大于 k 个时，如果大于堆顶则先 poll 堆顶再加入元素
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        // 倒序输出第 k 大元素
        int res = 0;
        for (int i = 0; i < pq.size() - k + 1 && !pq.isEmpty(); i++)
            res = pq.poll();

        return res;
    }
}
