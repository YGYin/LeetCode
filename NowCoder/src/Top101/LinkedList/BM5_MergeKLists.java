package Top101.LinkedList;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BM5_MergeKLists {

    /*
        分治法
        1. 从链表数组的首和尾开始，每次划分从中间开始划分，得到左边 n/2 个和右边 n/2 个链表
        2. 继续不断递归划分，直到每部分链表数为 1
        3. 将划分好的相邻两部分链表，按照两个有序链表合并的方式合并，
           合并好的两部分继续往上合并，直到最终合并成一个链表

        时间复杂度: O(nlogK)
            n 为所有链表总节点数，分治为二叉树递归，最坏情况每层合并 O(n) 个节点
            所以分治一共有 O(logK)层
     */
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return divideAndMerge(lists, 0, lists.size() - 1);
    }

    ListNode divideAndMerge(ArrayList<ListNode> lists, int left, int right) {
        // 本级任务: 对半划分，将划分后的子问题合并成新的链表
        // 终止条件: 划分的时候直到左右区间相等或左边大于右边
        if (left > right)
            return null;
            // 中间只有一个
        else if (left == right)
            return lists.get(left);
        // 从中间分成两段，再将合并好的两段合并
        int mid = (left + right) / 2;
        // 返回值: 每级返回已经合并好的子问题链表
        return mergeTwoList(divideAndMerge(lists, left, mid),
                divideAndMerge(lists, mid + 1, right));
    }

    ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null)
            cur.next = list1;
        else
            cur.next = list2;
        return head.next;
    }

    /*
        优先队列
        为了快速比较 k 个数字得到最小值，我们可以利用 PriorityQueue
        它是一种参照堆排序的容器，容器中的元素是有序的，
        如果是小顶堆，顶部元素就是最小的，每次可以直接取出最小的元素
        每次该容器中有 k 个元素，我们可以直接拿出最小的元素，再插入下一个元素，
        相当于每次都是链表的 k 个指针在比较大小，只移动最小元素的指针

        1. 重载比较方法，构造一个比较链表节点大小的小顶堆
        2. 先遍历k个链表头，将不是空节点的节点加入优先队列
        3. 每次依次弹出优先队列中的最小元素，将其连接在合并后的链表后面，
           然后将这个节点在原本链表中的后一个节点（不为空的话）加入队列，类似上述归并排序双指针的过程

        时间复杂度: O(nlogK)
            n 为所有链表总节点数，最坏需遍历所有节点，每次加入 PQ 排序需要 O(logK)
        空间复杂度: O(K)
            优先队列大小不会超出 K
     */
    public ListNode mergeKLists_2(ArrayList<ListNode> lists) {
        // 构建小顶堆
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        // 遍历所有链表的第一个元素
        for (int i = 0; i < lists.size(); ++i)
            if (lists.get(i) != null)
                pq.add(lists.get(i));
        // 新建链表
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (!pq.isEmpty()) {
            // 取出最小元素
            ListNode minTemp = pq.poll();
            // 连接到 res
            cur.next = minTemp;
            cur = cur.next;
            // 每次取出节点后，将该链表的后一个节点加入小顶堆
            if (minTemp.next != null)
                pq.add(minTemp.next);
        }
        return res.next;
    }
}
