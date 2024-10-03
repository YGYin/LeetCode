package round2.hot100.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    /*
        数据流的中位数
        分别构建大顶堆和小顶堆
        大顶堆用于储存中位数左边的数，小顶堆用于储存中位数右边的数，分别对应其堆顶
     */
    PriorityQueue<Integer> leftPQ;
    PriorityQueue<Integer> rightPQ;

    public MedianFinder() {
        // 大顶堆
        leftPQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 小顶堆
        rightPQ = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    /*
        添加元素
        根据两个堆的大小来分类讨论
        1. 如果左堆和右堆大小相等
            - 右为空或者元素小于右堆小堆顶时，直接放左堆
            - 大于右堆堆顶时就要放到右堆中，但要维护左边多一个，所以先 poll 一个放到左堆
        2. 左堆和右堆大小不相等，说明左堆一定有元素且大于右堆元素个数
            - 如果元素大于左堆顶，加入到右堆
            - 否则，为了维护左右堆，先从左堆 poll 一个放到右堆，然后再添加元素
     */
    public void addNum(int num) {
        int leftSize = leftPQ.size();
        int rightSize = rightPQ.size();
        if (leftSize == rightSize) {
            // 右为空或者元素小于右堆小堆顶时，直接放左堆
            if (rightPQ.isEmpty() || num <= rightPQ.peek())
                leftPQ.offer(num);
                // 大于右堆堆顶时就要放到右堆中，但要维护左边多一个，所以先 poll 一个放到左堆
            else {
                leftPQ.offer(rightPQ.poll());
                rightPQ.offer(num);
            }
        }
        // 左堆和右堆大小不相等，说明左堆一定有元素且大于右堆元素个数
        else {
            if (num >= leftPQ.peek())
                rightPQ.offer(num);
            else {
                rightPQ.offer(leftPQ.poll());
                leftPQ.offer(num);
            }
        }
    }

    // 1. 左右相等为偶数 -> 返回两个堆顶的平均值
    // 2. 左右不相等为奇数 -> 返回左堆顶（人为维护左堆顶多 1 个元素）
    public double findMedian() {
        return leftPQ.size() == rightPQ.size() ?
                (double) (leftPQ.peek() + rightPQ.peek()) / 2 :
                (double) leftPQ.peek();
    }
}
