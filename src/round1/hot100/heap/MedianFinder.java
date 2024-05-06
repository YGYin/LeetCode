package round1.hot100.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    // 数据流的中位数
    // 中位数是有序整数列表中的中间值。
    // 元素个数为奇数，取列表中间元素 [1, 2, 5] -> 2
    // 元素个数为偶数，则没有中间值，中位数是两个中间值的平均值
    // [1, 2] -> (1 + 2) / 2 -> 1.5

    /*
        可以分别构建维护大顶堆和小顶堆，并认为固定下列关系
        1. 当元素个数为偶数时，left 和 right 堆大小相同，中位数为两个堆顶平均值
        2. 当元素个数为奇数时，left 比 right 多一个元素，中位数为 left 的堆顶

        应该分情况给两个堆添加数字
        大顶堆存储较小的一半数字
        小顶堆存储较大的一半数字
        以实现 元素个数为奇数时，left 比 right 多一个元素，中位数为 left 的堆顶
        1. 两个堆大小相同时
        - right 最小值与输入值比较，小则直接左放；
          因为元素都比中位数的右边最小还小，肯定在左边

        - 反之 right 的最小值左移，新值右放
          比右边的最小值要大，说明放右边，
          但要维护左比右多 1，先将 right 堆顶移到左边再添加

        2. 大小不相同时
        - left 最大值与输入值比较，比 left 堆顶大直接右放
          如果都大于 left 堆顶，说明一定放右边

        - 反之 left 最大值右移，新值左放
          维护堆大小，先把左堆顶放到右边再放新元素
     */
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        // 大顶堆，维护中位数的左边元素
        this.left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 小顶堆，维护中位数的右边元素
        this.right = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        // 先获取两个堆的大小，根据大小分情况讨论
        int leftSize = left.size();
        int rightSize = right.size();
        // 1. 两个堆大小相同时
        if (leftSize == rightSize) {
            // right 最小值与输入值比较，小则直接左放
            // 因为元素都比中位数的右边最小还小，肯定在左边
            // 或者 right 为空时
            if (right.isEmpty() || num <= right.peek())
                left.add(num);
                // 比右边的最小值要大，说明放右边，
                // 但要维护左比右多 1，先将 right 堆顶移到左边再添加
            else {
                left.add(right.poll());
                right.add(num);
            }
        }
        // 2. 两个堆大小不相等，左边一定有元素
        else {
            // left 最大值与输入值比较，
            // 如果都大于 left 堆顶，说明一定放右边
            if (num >= left.peek())
                right.add(num);
                // 放左边，但是需要维护大小，先将左堆顶右移再添加
            else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        // 同样先获取左右堆的大小
        int leftSize = left.size();
        int rightSize = right.size();
        // 1. 左右相等为偶数 -> 返回两个堆顶的平均值
        // 2. 左右不相等为奇数 -> 返回左堆顶（人为维护左堆顶多 1 个元素）
        return leftSize == rightSize ? (double) (left.peek() + right.peek()) / 2
                : (double) left.peek();
    }

}

